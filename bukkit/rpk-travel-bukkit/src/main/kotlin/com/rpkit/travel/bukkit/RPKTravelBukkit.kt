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

package com.rpkit.travel.bukkit

import com.rpkit.core.bukkit.plugin.RPKBukkitPlugin
import com.rpkit.core.database.Database
import com.rpkit.travel.bukkit.command.DeleteWarpCommand
import com.rpkit.travel.bukkit.command.SetWarpCommand
import com.rpkit.travel.bukkit.command.WarpCommand
import com.rpkit.travel.bukkit.database.table.RPKWarpTable
import com.rpkit.travel.bukkit.listener.PlayerInteractListener
import com.rpkit.travel.bukkit.listener.SignChangeListener
import com.rpkit.travel.bukkit.warp.RPKWarpProviderImpl
import org.bstats.bukkit.Metrics


class RPKTravelBukkit: RPKBukkitPlugin() {

    override fun onEnable() {
        Metrics(this, 4424)
        saveDefaultConfig()
        serviceProviders = arrayOf(
                RPKWarpProviderImpl(this)
        )
    }

    override fun registerListeners() {
        registerListeners(
                PlayerInteractListener(this),
                SignChangeListener(this)
        )
    }

    override fun registerCommands() {
        getCommand("deletewarp")?.setExecutor(DeleteWarpCommand(this))
        getCommand("setwarp")?.setExecutor(SetWarpCommand(this))
        getCommand("warp")?.setExecutor(WarpCommand(this))
    }

    override fun createTables(database: Database) {
        database.addTable(RPKWarpTable(database, this))
    }

    override fun setDefaultMessages() {
        messages.setDefault("no-minecraft-profile", "&cA Minecraft profile has not been created for you, or was unable to be retrieved. Please try relogging, and contact the server owner if this error persists.")
        messages.setDefault("delete-warp-valid", "&aDeleted warp \$warp.")
        messages.setDefault("delete-warp-usage", "&cUsage: /deletewarp [warp]")
        messages.setDefault("set-warp-invalid-name-already-in-use", "&cA warp by that name already exists.")
        messages.setDefault("set-warp-valid", "&aWarp \$warp set in \$world at \$x, \$y, \$z")
        messages.setDefault("set-warp-usage", "&cUsage: /setwarp [name]")
        messages.setDefault("warp-valid", "&aWarped to \$warp.")
        messages.setDefault("warp-invalid-warp", "&cThere is no warp by that name.")
        messages.setDefault("warp-list-title", "&fWarps")
        messages.setDefault("warp-list-item", "&7\$warps")
        messages.setDefault("warp-list-invalid-empty", "&cNo warps are currently set. Set one using /setwarp [name].")
        messages.setDefault("warp-sign-invalid-warp", "&cThere is no warp by that name.")
        messages.setDefault("warp-sign-valid", "&aWarp sign created.")
        messages.setDefault("no-permission-delete-warp", "&cYou do not have permission to delete warps.")
        messages.setDefault("no-permission-set-warp", "&cYou do not have permission to set warps.")
        messages.setDefault("no-permission-warp-sign-create", "&cYou do not have permission to create warp signs.")
        messages.setDefault("no-permission-warp", "&cYou do not have permission to warp.")
    }

}