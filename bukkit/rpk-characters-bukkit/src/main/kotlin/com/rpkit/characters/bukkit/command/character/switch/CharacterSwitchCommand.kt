/*
 * Copyright 2020 Ren Binden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rpkit.characters.bukkit.command.character.switch

import com.rpkit.characters.bukkit.RPKCharactersBukkit
import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import com.rpkit.players.bukkit.profile.RPKProfile
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.conversations.*
import org.bukkit.entity.Player

/**
 * Character switch command.
 * Switches active character.
 */
class CharacterSwitchCommand(private val plugin: RPKCharactersBukkit): CommandExecutor {
    private val conversationFactory: ConversationFactory

    init {
        conversationFactory = ConversationFactory(plugin)
                .withModality(true)
                .withFirstPrompt(CharacterPrompt())
                .withEscapeSequence("cancel")
                .thatExcludesNonPlayersWithMessage(plugin.messages["not-from-console"])
                .addConversationAbandonedListener { event ->
            if (!event.gracefulExit()) {
                val conversable = event.context.forWhom
                if (conversable is Player) {
                    conversable.sendMessage(plugin.messages["operation-cancelled"])
                }
            }
        }
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            if (sender.hasPermission("rpkit.characters.command.character.switch")) {
                if (args.isNotEmpty()) {
                    val characterNameBuilder = StringBuilder()
                    for (i in 0 until args.size - 1) {
                        characterNameBuilder.append(args[i]).append(" ")
                    }
                    characterNameBuilder.append(args[args.size - 1])
                    val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                    val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                    val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(sender)
                    if (minecraftProfile != null) {
                        val profile = minecraftProfile.profile
                        if (profile is RPKProfile) {
                            var charFound = false
                            var unplayableOtherAccount = false // Has a character been skipped due to already being played on another account?
                            // Prioritise exact matches...
                            characterProvider.getCharacters(profile)
                                    .filter { it.name.equals(characterNameBuilder.toString(), ignoreCase = true) }
                                    .forEach {
                                        if (it.minecraftProfile == null) {
                                            characterProvider.setActiveCharacter(minecraftProfile, it)
                                            charFound = true
                                        } else {
                                            unplayableOtherAccount = true
                                        }
                                    }
                            // And fall back to partial matches
                            if (!charFound) {
                                characterProvider.getCharacters(profile)
                                        .filter { it.name.toLowerCase().contains(characterNameBuilder.toString().toLowerCase()) }
                                        .forEach {
                                            if (it.minecraftProfile == null) {
                                                characterProvider.setActiveCharacter(minecraftProfile, it)
                                                charFound = true
                                            } else {
                                                unplayableOtherAccount = true
                                            }
                                        }
                            }
                            if (charFound) {
                                sender.sendMessage(plugin.messages["character-switch-valid"])
                            } else {
                                if (unplayableOtherAccount) {
                                    sender.sendMessage(plugin.messages["character-switch-invalid-character-other-account"])
                                } else {
                                    sender.sendMessage(plugin.messages["character-switch-invalid-character"])
                                }
                            }
                        } else {
                            sender.sendMessage(plugin.messages["no-profile"])
                        }
                    } else {
                        sender.sendMessage(plugin.messages["no-minecraft-profile"])
                    }
                } else {
                    conversationFactory.buildConversation(sender).begin()
                }
            } else {
                sender.sendMessage(plugin.messages["no-permission-character-switch"])
            }
        } else {
            sender.sendMessage(plugin.messages["not-from-console"])
        }
        return true
    }

    private inner class CharacterPrompt: ValidatingPrompt() {

        override fun isInputValid(context: ConversationContext, input: String): Boolean {
            val conversable = context.forWhom
            if (conversable is Player) {
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(conversable)
                if (minecraftProfile != null) {
                    val profile = minecraftProfile.profile
                    if (profile is RPKProfile) {
                        repeat(characterProvider.getCharacters(profile)
                                .filter { it.name.equals(input, ignoreCase = true) }
                                .filter { it.minecraftProfile == null }.size) { return true }
                        repeat(characterProvider.getCharacters(profile)
                                .filter { it.name.toLowerCase().contains(input.toLowerCase()) }
                                .filter { it.minecraftProfile == null }.size) { return true }
                    }
                }
            }
            return false
        }

        override fun acceptValidatedInput(context: ConversationContext, input: String): Prompt {
            val conversable = context.forWhom
            if (conversable is Player) {
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(conversable)
                if (minecraftProfile != null) {
                    val profile = minecraftProfile.profile
                    if (profile is RPKProfile) {
                        var charFound = false
                        // Prioritise exact matches...
                        characterProvider.getCharacters(profile)
                                .filter { it.name.equals(input, ignoreCase = true) }
                                .forEach {
                                    if (it.minecraftProfile == null) {
                                        characterProvider.setActiveCharacter(minecraftProfile, it)
                                        charFound = true
                                    }
                                }
                        // And fall back to partial matches
                        if (!charFound) {
                            characterProvider.getCharacters(profile)
                                    .filter { it.name.toLowerCase().contains(input.toLowerCase()) }
                                    .forEach {
                                        if (it.minecraftProfile == null) {
                                            characterProvider.setActiveCharacter(minecraftProfile, it)
                                            charFound = true
                                        }
                                    }
                        }
                        return CharacterSwitchedPrompt()
                    } else {
                        return END_OF_CONVERSATION
                    }
                } else {
                    return END_OF_CONVERSATION
                }
            } else {
                return END_OF_CONVERSATION
            }
        }

        override fun getFailedValidationText(context: ConversationContext, invalidInput: String): String {
            val conversable = context.forWhom
            if (conversable is Player) {
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
                val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(conversable)
                if (minecraftProfile != null) {
                    val profile = minecraftProfile.profile
                    if (profile is RPKProfile) {
                        var charFound = false
                        // Prioritise exact matches...
                        characterProvider.getCharacters(profile)
                                .filter { it.name.equals(invalidInput, ignoreCase = true) }
                                .forEach {
                                    charFound = true
                                    if (it.minecraftProfile != null) {
                                        return plugin.messages["character-switch-invalid-character-other-account"]
                                    }
                                }
                        // And fall back to partial matches
                        if (!charFound) {
                            characterProvider.getCharacters(profile)
                                    .filter { it.name.toLowerCase().contains(invalidInput.toLowerCase()) }
                                    .forEach {
                                        if (it.minecraftProfile != null) {
                                            return plugin.messages["character-switch-invalid-character-other-account"]
                                        }
                                    }
                        }
                    }
                }
            }
            return plugin.messages["character-switch-invalid-character"]
        }

        override fun getPromptText(context: ConversationContext): String {
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(context.forWhom as Player)
            if (minecraftProfile != null) {
                val profile = minecraftProfile.profile
                return if (profile is RPKProfile) {
                    val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                    val characterListBuilder = StringBuilder()
                    for (character in characterProvider.getCharacters(profile)) {
                        characterListBuilder.append("\n").append(
                                plugin.messages["character-list-item", mapOf(
                                        Pair("character", character.name)
                                )])
                    }
                    plugin.messages["character-switch-prompt"] + characterListBuilder.toString()
                } else {
                    plugin.messages["no-profile"]
                }
            } else {
                return plugin.messages["no-minecraft-profile"]
            }
        }

    }

    private inner class CharacterSwitchedPrompt: MessagePrompt() {

        override fun getNextPrompt(context: ConversationContext): Prompt? {
            return END_OF_CONVERSATION
        }

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["character-switch-valid"]
        }
    }

}
