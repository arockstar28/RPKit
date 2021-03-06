/*
 * This file is generated by jOOQ.
*/
package com.rpkit.chat.bukkit.database.jooq.rpkit.tables;


import com.rpkit.chat.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.chat.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.chat.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.chat.bukkit.database.jooq.rpkit.tables.records.RpkitChatChannelMuteRecord;

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
public class RpkitChatChannelMute extends TableImpl<RpkitChatChannelMuteRecord> {

    private static final long serialVersionUID = 1837124110;

    /**
     * The reference instance of <code>rpkit.rpkit_chat_channel_mute</code>
     */
    public static final RpkitChatChannelMute RPKIT_CHAT_CHANNEL_MUTE = new RpkitChatChannelMute();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitChatChannelMuteRecord> getRecordType() {
        return RpkitChatChannelMuteRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_chat_channel_mute.id</code>.
     */
    public final TableField<RpkitChatChannelMuteRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_chat_channel_mute.minecraft_profile_id</code>.
     */
    public final TableField<RpkitChatChannelMuteRecord, Integer> MINECRAFT_PROFILE_ID = createField("minecraft_profile_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_chat_channel_mute.chat_channel_id</code>.
     */
    public final TableField<RpkitChatChannelMuteRecord, Integer> CHAT_CHANNEL_ID = createField("chat_channel_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>rpkit.rpkit_chat_channel_mute</code> table reference
     */
    public RpkitChatChannelMute() {
        this(DSL.name("rpkit_chat_channel_mute"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_chat_channel_mute</code> table reference
     */
    public RpkitChatChannelMute(String alias) {
        this(DSL.name(alias), RPKIT_CHAT_CHANNEL_MUTE);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_chat_channel_mute</code> table reference
     */
    public RpkitChatChannelMute(Name alias) {
        this(alias, RPKIT_CHAT_CHANNEL_MUTE);
    }

    private RpkitChatChannelMute(Name alias, Table<RpkitChatChannelMuteRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitChatChannelMute(Name alias, Table<RpkitChatChannelMuteRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.RPKIT_CHAT_CHANNEL_MUTE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitChatChannelMuteRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_CHAT_CHANNEL_MUTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitChatChannelMuteRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_CHAT_CHANNEL_MUTE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitChatChannelMuteRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitChatChannelMuteRecord>>asList(Keys.KEY_RPKIT_CHAT_CHANNEL_MUTE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitChatChannelMute as(String alias) {
        return new RpkitChatChannelMute(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitChatChannelMute as(Name alias) {
        return new RpkitChatChannelMute(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitChatChannelMute rename(String name) {
        return new RpkitChatChannelMute(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitChatChannelMute rename(Name name) {
        return new RpkitChatChannelMute(name, null);
    }
}
