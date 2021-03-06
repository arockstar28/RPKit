/*
 * This file is generated by jOOQ.
*/
package com.rpkit.moderation.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.moderation.bukkit.database.jooq.rpkit.tables.RpkitVanishState;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class RpkitVanishStateRecord extends UpdatableRecordImpl<RpkitVanishStateRecord> implements Record3<Integer, Integer, Byte> {

    private static final long serialVersionUID = -1723156480;

    /**
     * Setter for <code>rpkit.rpkit_vanish_state.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_vanish_state.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_vanish_state.minecraft_profile_id</code>.
     */
    public void setMinecraftProfileId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_vanish_state.minecraft_profile_id</code>.
     */
    public Integer getMinecraftProfileId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_vanish_state.vanished</code>.
     */
    public void setVanished(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_vanish_state.vanished</code>.
     */
    public Byte getVanished() {
        return (Byte) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Byte> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Byte> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitVanishState.RPKIT_VANISH_STATE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitVanishState.RPKIT_VANISH_STATE.MINECRAFT_PROFILE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field3() {
        return RpkitVanishState.RPKIT_VANISH_STATE.VANISHED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getMinecraftProfileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component3() {
        return getVanished();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getMinecraftProfileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value3() {
        return getVanished();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitVanishStateRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitVanishStateRecord value2(Integer value) {
        setMinecraftProfileId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitVanishStateRecord value3(Byte value) {
        setVanished(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitVanishStateRecord values(Integer value1, Integer value2, Byte value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitVanishStateRecord
     */
    public RpkitVanishStateRecord() {
        super(RpkitVanishState.RPKIT_VANISH_STATE);
    }

    /**
     * Create a detached, initialised RpkitVanishStateRecord
     */
    public RpkitVanishStateRecord(Integer id, Integer minecraftProfileId, Byte vanished) {
        super(RpkitVanishState.RPKIT_VANISH_STATE);

        set(0, id);
        set(1, minecraftProfileId);
        set(2, vanished);
    }
}
