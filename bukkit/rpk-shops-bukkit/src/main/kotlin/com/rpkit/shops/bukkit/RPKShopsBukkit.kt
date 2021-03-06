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

package com.rpkit.shops.bukkit

import com.rpkit.core.bukkit.plugin.RPKBukkitPlugin
import com.rpkit.core.database.Database
import com.rpkit.shops.bukkit.command.RestockCommand
import com.rpkit.shops.bukkit.database.table.RPKShopCountTable
import com.rpkit.shops.bukkit.listener.BlockBreakListener
import com.rpkit.shops.bukkit.listener.InventoryClickListener
import com.rpkit.shops.bukkit.listener.PlayerInteractListener
import com.rpkit.shops.bukkit.listener.SignChangeListener
import com.rpkit.shops.bukkit.shopcount.RPKShopCountProviderImpl
import org.bstats.bukkit.Metrics

/**
 * RPK shops plugin default implementation.
 */
class RPKShopsBukkit: RPKBukkitPlugin() {

    override fun onEnable() {
        Metrics(this, 4415)
        saveDefaultConfig()
        serviceProviders = arrayOf(
                RPKShopCountProviderImpl(this)
        )
    }

    override fun registerListeners() {
        registerListeners(
                SignChangeListener(this),
                BlockBreakListener(this),
                PlayerInteractListener(this),
                InventoryClickListener(this)
        )
    }

    override fun registerCommands() {
        getCommand("restock")?.setExecutor(RestockCommand(this))
    }

    override fun createTables(database: Database) {
        database.addTable(RPKShopCountTable(database, this))
    }

    override fun setDefaultMessages() {
        messages.setDefault("restock-valid", "&aShop restocked.")
        messages.setDefault("restock-invalid-material", "&cThere is no material by that name.")
        messages.setDefault("restock-invalid-chest", "&cYou must be looking at a chest.")
        messages.setDefault("restock-usage", "&cUsage: /restock [material]")
        messages.setDefault("shop-line-1-invalid", "&cLine 1 format must be \"buy [number]\" or \"sell [number] [type]\"")
        messages.setDefault("shop-line-2-invalid", "&cLine 2 format must be \"for [price] [currency]\"")
        messages.setDefault("rent-line-2-invalid", "&cLine 2 format must be \"[cost] [currency]\"")
        messages.setDefault("rent-paid", "&aPaid for the next day of rent.")
        messages.setDefault("rent-ended", "&cThe lease on this shop has ended.")
        messages.setDefault("rent-invalid-currency", "&cRent is being charged in an invalid currency. Please get the owner to fix it.")
        messages.setDefault("rent-invalid-character", "&cThe character who is charging rent no longer exists.")
        messages.setDefault("rent-not-owner", "&cYou cannot pay rent for a shop you do not own.")
        messages.setDefault("rent-no-shop", "&cYou must create a shop before attempting to pay rent.")
        messages.setDefault("no-permission-shop", "&cYou do not have permission to create shops.")
        messages.setDefault("no-permission-shop-limit", "&cYou have surpassed the shop limit.")
        messages.setDefault("no-permission-shop-admin", "&cYou do not have permission to create admin shops.")
        messages.setDefault("no-permission-restock", "&cYou do not have permission to restock chests")
        messages.setDefault("no-permission-rent", "&cYou do not have permission to charge rent for shops.")
        messages.setDefault("no-character", "&cYou need a character in order to perform this action.")
        messages.setDefault("no-stealing", "&cYou cannot steal from this shop.")
        messages.setDefault("not-enough-money", "&cYou do not have enough money to buy that.")
        messages.setDefault("not-enough-shop-items", "&cThe shop does not contain enough items.")
        messages.setDefault("shop-sell-not-enough-money", "&cThe shop's owner does not have enough money to pay you.")
        messages.setDefault("shop-sell-chest-not-found", "&cCould not find a chest below that shop to place your item into.")
        messages.setDefault("shop-sell-not-enough-items", "&cYou do not have enough items to sell to that shop.")
        messages.setDefault("shop-character-invalid", "&cThere is no character with that ID. Perhaps they have been deleted?")
        messages.setDefault("shop-currency-invalid", "&cThere is no currency by that name.")
        messages.setDefault("shop-material-invalid", "&cThere is no material by that name.")
        messages.setDefault("trader-material-invalid", "&cThere is no material by that name.")
        messages.setDefault("not-from-console", "&cYou must be a player to perform that command.")
        messages.setDefault("no-minecraft-profile", "&cA Minecraft profile has not been created for you, or was unable to be retrieved. Please try relogging, and contact the server owner if this error persists.")
    }

}