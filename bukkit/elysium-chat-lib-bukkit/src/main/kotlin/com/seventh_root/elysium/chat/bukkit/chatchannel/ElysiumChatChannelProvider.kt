/*
 * Copyright 2016 Ross Binden
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

package com.seventh_root.elysium.chat.bukkit.chatchannel

import com.seventh_root.elysium.core.service.ServiceProvider
import com.seventh_root.elysium.players.bukkit.player.ElysiumPlayer

/**
 * Provides chat channel related operations.
 */
interface ElysiumChatChannelProvider: ServiceProvider {

    /**
     * A collection of all chat channels currently managed by this chat channel provider.
     * The collection is immutable, chat channels must be added and removed using [addChatChannel] and
     * [removeChatChannel].
     */
    val chatChannels: Collection<ElysiumChatChannel>

    /**
     * Gets a chat channel by ID.
     * If there is no chat channel with the given ID, null is returned.
     *
     * @param id The ID of the chat channel
     * @return The chat channel, or null if no chat channel is found with the given ID
     */
    fun getChatChannel(id: Int): ElysiumChatChannel?

    /**
     * Gets a chat channel by name.
     * If there is no chat channel with the given name, null is returned.
     *
     * @param name The name of the chat channel
     * @return The chat channel, or null if no chat channel is found with the given name
     */
    fun getChatChannel(name: String): ElysiumChatChannel?

    /**
     * Adds a chat channel to be tracked by this chat channel provider.
     *
     * @param chatChannel The chat channel to add
     */
    fun addChatChannel(chatChannel: ElysiumChatChannel)

    /**
     * Removes a chat channel from being tracked by this chat channel provider.
     *
     * @param chatChannel The chat channel to remove
     */
    fun removeChatChannel(chatChannel: ElysiumChatChannel)

    /**
     * Updates a chat channel's state in data storage.
     *
     * @param chatChannel The chat channel to update
     */
    fun updateChatChannel(chatChannel: ElysiumChatChannel)

    /**
     * Gets the chat channel a player is currently speaking in.
     * If the player is not currently speaking in a channel, null is returned.
     *
     * @param player The player
     * @return The chat channel the player is currently speaking in, or null if the player is not currently speaking in
     *         a channel.
     */
    fun getPlayerChannel(player: ElysiumPlayer): ElysiumChatChannel?

    /**
     * Sets the chat channel a player is currently speaking in.
     *
     * @param player The player
     * @param channel The channel to set
     */
    fun setPlayerChannel(player: ElysiumPlayer, channel: ElysiumChatChannel)

    /**
     * Gets a chat channel from the IRC channel it is linked to.
     * If no chat channel uses the given IRC channel, null is returned.
     *
     * @param ircChannel The IRC channel
     * @return The chat channel, or null if no chat channel uses the given IRC channel.
     */
    fun getChatChannelFromIRCChannel(ircChannel: String): ElysiumChatChannel?

}