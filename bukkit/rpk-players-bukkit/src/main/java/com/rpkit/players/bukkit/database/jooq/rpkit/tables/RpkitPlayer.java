/*
 * This file is generated by jOOQ.
*/
package com.rpkit.players.bukkit.database.jooq.rpkit.tables;


import com.rpkit.players.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.players.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.players.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.players.bukkit.database.jooq.rpkit.tables.records.RpkitPlayerRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitPlayer extends TableImpl<RpkitPlayerRecord> {

    private static final long serialVersionUID = 851347589;

    /**
     * The reference instance of <code>rpkit.rpkit_player</code>
     */
    public static final RpkitPlayer RPKIT_PLAYER = new RpkitPlayer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitPlayerRecord> getRecordType() {
        return RpkitPlayerRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_player.id</code>.
     */
    public final TableField<RpkitPlayerRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_player.name</code>.
     */
    public final TableField<RpkitPlayerRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>rpkit.rpkit_player.minecraft_uuid</code>.
     */
    public final TableField<RpkitPlayerRecord, String> MINECRAFT_UUID = createField("minecraft_uuid", org.jooq.impl.SQLDataType.VARCHAR(36), this, "");

    /**
     * The column <code>rpkit.rpkit_player.irc_nick</code>.
     */
    public final TableField<RpkitPlayerRecord, String> IRC_NICK = createField("irc_nick", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>rpkit.rpkit_player.last_known_ip</code>.
     */
    public final TableField<RpkitPlayerRecord, String> LAST_KNOWN_IP = createField("last_known_ip", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * Create a <code>rpkit.rpkit_player</code> table reference
     */
    public RpkitPlayer() {
        this(DSL.name("rpkit_player"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_player</code> table reference
     */
    public RpkitPlayer(String alias) {
        this(DSL.name(alias), RPKIT_PLAYER);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_player</code> table reference
     */
    public RpkitPlayer(Name alias) {
        this(alias, RPKIT_PLAYER);
    }

    private RpkitPlayer(Name alias, Table<RpkitPlayerRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitPlayer(Name alias, Table<RpkitPlayerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Rpkit.RPKIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.RPKIT_PLAYER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitPlayerRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_PLAYER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitPlayerRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_PLAYER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitPlayerRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitPlayerRecord>>asList(Keys.KEY_RPKIT_PLAYER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitPlayer as(String alias) {
        return new RpkitPlayer(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitPlayer as(Name alias) {
        return new RpkitPlayer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitPlayer rename(String name) {
        return new RpkitPlayer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitPlayer rename(Name name) {
        return new RpkitPlayer(name, null);
    }
}
