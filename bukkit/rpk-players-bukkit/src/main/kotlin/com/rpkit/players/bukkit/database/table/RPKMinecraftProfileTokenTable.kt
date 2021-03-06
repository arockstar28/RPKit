package com.rpkit.players.bukkit.database.table

import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.players.bukkit.RPKPlayersBukkit
import com.rpkit.players.bukkit.database.jooq.rpkit.Tables.RPKIT_MINECRAFT_PROFILE_TOKEN
import com.rpkit.players.bukkit.profile.RPKMinecraftProfile
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileProvider
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileToken
import com.rpkit.players.bukkit.profile.RPKMinecraftProfileTokenImpl
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder
import org.jooq.impl.DSL.constraint
import org.jooq.impl.SQLDataType


class RPKMinecraftProfileTokenTable(database: Database, private val plugin: RPKPlayersBukkit): Table<RPKMinecraftProfileToken>(database, RPKMinecraftProfileToken::class) {

    private val cache = if (plugin.config.getBoolean("caching.rpkit_minecraft_profile_token.id.enabled")) {
        database.cacheManager.createCache("rpk-players-bukkit.rpkit_minecraft_profile_token.id",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Int::class.javaObjectType, RPKMinecraftProfileToken::class.java,
                        ResourcePoolsBuilder.heap(plugin.config.getLong("caching.rpkit_minecraft_profile_token.id.size"))))
    } else {
        null
    }

    override fun create() {
        database.create
                .createTableIfNotExists(RPKIT_MINECRAFT_PROFILE_TOKEN)
                .column(RPKIT_MINECRAFT_PROFILE_TOKEN.ID, SQLDataType.INTEGER.identity(true))
                .column(RPKIT_MINECRAFT_PROFILE_TOKEN.MINECRAFT_PROFILE_ID, SQLDataType.INTEGER)
                .column(RPKIT_MINECRAFT_PROFILE_TOKEN.TOKEN, SQLDataType.VARCHAR(36))
                .constraints(
                        constraint("pk_rpkit_minecraft_profile_token").primaryKey(RPKIT_MINECRAFT_PROFILE_TOKEN.ID)
                )
                .execute()
    }

    override fun applyMigrations() {
        if (database.getTableVersion(this) == null) {
            database.setTableVersion(this, "1.3.0")
        }
    }

    override fun insert(entity: RPKMinecraftProfileToken): Int {
        database.create
                .insertInto(
                        RPKIT_MINECRAFT_PROFILE_TOKEN,
                        RPKIT_MINECRAFT_PROFILE_TOKEN.MINECRAFT_PROFILE_ID,
                        RPKIT_MINECRAFT_PROFILE_TOKEN.TOKEN
                )
                .values(
                        entity.minecraftProfile.id,
                        entity.token
                )
                .execute()
        val id = database.create.lastID().toInt()
        entity.id = id
        cache?.put(id, entity)
        return id
    }

    override fun update(entity: RPKMinecraftProfileToken) {
        database.create
                .update(RPKIT_MINECRAFT_PROFILE_TOKEN)
                .set(RPKIT_MINECRAFT_PROFILE_TOKEN.MINECRAFT_PROFILE_ID, entity.minecraftProfile.id)
                .set(RPKIT_MINECRAFT_PROFILE_TOKEN.TOKEN, entity.token)
                .where(RPKIT_MINECRAFT_PROFILE_TOKEN.ID.eq(entity.id))
                .execute()
        cache?.put(entity.id, entity)
    }

    override fun get(id: Int): RPKMinecraftProfileToken? {
        if (cache?.containsKey(id) == true) {
            return cache.get(id)
        } else {
            val result = database.create
                    .select(
                            RPKIT_MINECRAFT_PROFILE_TOKEN.MINECRAFT_PROFILE_ID,
                            RPKIT_MINECRAFT_PROFILE_TOKEN.TOKEN
                    )
                    .from(RPKIT_MINECRAFT_PROFILE_TOKEN)
                    .where(RPKIT_MINECRAFT_PROFILE_TOKEN.ID.eq(id))
                    .fetchOne() ?: return null
            val minecraftProfileProvider = plugin.core.serviceManager.getServiceProvider(RPKMinecraftProfileProvider::class)
            val minecraftProfileId = result.get(RPKIT_MINECRAFT_PROFILE_TOKEN.MINECRAFT_PROFILE_ID)
            val minecraftProfile = minecraftProfileProvider.getMinecraftProfile(minecraftProfileId)
            return if (minecraftProfile != null) {
                val minecraftProfileToken = RPKMinecraftProfileTokenImpl(
                        id,
                        minecraftProfile,
                        result.get(RPKIT_MINECRAFT_PROFILE_TOKEN.TOKEN)
                )
                cache?.put(id, minecraftProfileToken)
                minecraftProfileToken
            } else {
                database.create
                        .deleteFrom(RPKIT_MINECRAFT_PROFILE_TOKEN)
                        .where(RPKIT_MINECRAFT_PROFILE_TOKEN.ID.eq(id))
                        .execute()
                null
            }
        }
    }

    fun get(profile: RPKMinecraftProfile): RPKMinecraftProfileToken? {
        val result = database.create
                .select(RPKIT_MINECRAFT_PROFILE_TOKEN.ID)
                .from(RPKIT_MINECRAFT_PROFILE_TOKEN)
                .where(RPKIT_MINECRAFT_PROFILE_TOKEN.MINECRAFT_PROFILE_ID.eq(profile.id))
                .fetchOne() ?: return null
        return get(result.get(RPKIT_MINECRAFT_PROFILE_TOKEN.ID))
    }

    override fun delete(entity: RPKMinecraftProfileToken) {
        database.create
                .deleteFrom(RPKIT_MINECRAFT_PROFILE_TOKEN)
                .where(RPKIT_MINECRAFT_PROFILE_TOKEN.ID.eq(entity.id))
                .execute()
        cache?.remove(entity.id)
    }

}