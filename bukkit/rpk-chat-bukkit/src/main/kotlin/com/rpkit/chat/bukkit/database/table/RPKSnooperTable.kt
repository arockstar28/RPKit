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

package com.rpkit.chat.bukkit.database.table

import com.rpkit.chat.bukkit.RPKChatBukkit
import com.rpkit.chat.bukkit.snooper.RPKSnooper
import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.core.database.use
import com.rpkit.players.bukkit.player.RPKPlayer
import com.rpkit.players.bukkit.player.RPKPlayerProvider
import org.ehcache.Cache
import org.ehcache.CacheManager
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.CacheManagerBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder
import java.sql.Statement.RETURN_GENERATED_KEYS

/**
 * Represents the snooper table.
 */
class RPKSnooperTable: Table<RPKSnooper> {

    private val plugin: RPKChatBukkit
    private val cacheManager: CacheManager
    private val cache: Cache<Int, RPKSnooper>
    private val playerCache: Cache<Int, Int>

    constructor(database: Database, plugin: RPKChatBukkit) : super(database, RPKSnooper::class) {
        this.plugin = plugin
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true)
        cache = cacheManager.createCache("cache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Int::class.javaObjectType, RPKSnooper::class.java,
                        ResourcePoolsBuilder.heap(plugin.server.maxPlayers.toLong())).build())
        playerCache = cacheManager.createCache("playerCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Int::class.javaObjectType, Int::class.javaObjectType,
                        ResourcePoolsBuilder.heap(plugin.server.maxPlayers.toLong())).build())
    }

    override fun applyMigrations() {
        if (database.getTableVersion(this) == null) {
            database.setTableVersion(this, "0.3.0")
        }
    }

    override fun create() {
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS rpkit_snooper(" +
                            "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                            "player_id INTEGER" +
                    ")"
            ).use { statement ->
                statement.executeUpdate()
            }
        }
    }

    override fun insert(entity: RPKSnooper): Int {
        var id: Int = 0
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "INSERT INTO rpkit_snooper(player_id) VALUES(?)",
                    RETURN_GENERATED_KEYS
            ).use { statement ->
                statement.setInt(1, entity.player.id)
                statement.executeUpdate()
                val generatedKeys = statement.generatedKeys
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1)
                    entity.id = id
                    cache.put(id, entity)
                    playerCache.put(entity.player.id, entity.id)
                }
            }
        }
        return id
    }

    override fun update(entity: RPKSnooper) {
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "UPDATE rpkit_snooper SET player_id = ? WHERE id = ?"
            ).use { statement ->
                statement.setInt(1, entity.player.id)
                statement.setInt(2, entity.id)
                statement.executeUpdate()
                cache.put(entity.id, entity)
                playerCache.put(entity.player.id, entity.id)
            }
        }
    }

    override fun get(id: Int): RPKSnooper? {
        if (cache.containsKey(id)) {
            return cache.get(id)
        } else {
            var snooper: RPKSnooper? = null
            database.createConnection().use { connection ->
                connection.prepareStatement(
                        "SELECT id, player_id FROM rpkit_snooper WHERE id = ?"
                ).use { statement ->
                    statement.setInt(1, id)
                    val resultSet = statement.executeQuery()
                    if (resultSet.next()) {
                        val finalSnooper = RPKSnooper(
                                resultSet.getInt("id"),
                                plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class).getPlayer(resultSet.getInt("player_id"))!!
                        )
                        snooper = finalSnooper
                        cache.put(id, finalSnooper)
                        playerCache.put(finalSnooper.player.id, finalSnooper.id)
                    }
                }
            }
            return snooper
        }
    }

    /**
     * Gets the snooper instance for a player.
     * If the player does not have a snooper entry, null is returned.
     *
     * @param player The player
     * @return The snooper instance, or null if none exists
     */
    fun get(player: RPKPlayer): RPKSnooper? {
        if (playerCache.containsKey(player.id)) {
            return get(playerCache.get(player.id))
        } else {
            var snooper: RPKSnooper? = null
            database.createConnection().use { connection ->
                connection.prepareStatement(
                        "SELECT id, player_id FROM rpkit_snooper WHERE player_id = ?"
                ).use { statement ->
                    statement.setInt(1, player.id)
                    val resultSet = statement.executeQuery()
                    if (resultSet.next()) {
                        val finalSnooper = RPKSnooper(
                                resultSet.getInt("id"),
                                plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class).getPlayer(resultSet.getInt("player_id"))!!
                        )
                        snooper = finalSnooper
                        cache.put(finalSnooper.id, finalSnooper)
                        playerCache.put(finalSnooper.player.id, finalSnooper.id)
                    }
                }
            }
            return snooper
        }
    }

    /**
     * Gets all snoopers
     *
     * @return A list containing all snoopers
     */
    fun getAll(): List<RPKSnooper> {
        val snoopers = mutableListOf<RPKSnooper>()
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "SELECT id FROM rpkit_snooper"
            ).use { statement ->
                val resultSet = statement.executeQuery()
                while (resultSet.next()) {
                    snoopers.add(get(resultSet.getInt("id"))!!)
                }
            }
        }
        return snoopers
    }

    override fun delete(entity: RPKSnooper) {
        database.createConnection().use { connection ->
            connection.prepareStatement(
                    "DELETE FROM rpkit_snooper WHERE id = ?"
            ).use { statement ->
                statement.setInt(1, entity.id)
                statement.executeUpdate()
                cache.remove(entity.id)
                playerCache.remove(entity.player.id)
            }
        }
    }

}