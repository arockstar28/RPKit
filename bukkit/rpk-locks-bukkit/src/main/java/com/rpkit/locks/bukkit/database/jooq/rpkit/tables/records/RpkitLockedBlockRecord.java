/*
 * This file is generated by jOOQ.
*/
package com.rpkit.locks.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.locks.bukkit.database.jooq.rpkit.tables.RpkitLockedBlock;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class RpkitLockedBlockRecord extends UpdatableRecordImpl<RpkitLockedBlockRecord> implements Record5<Integer, String, Integer, Integer, Integer> {

    private static final long serialVersionUID = 589726389;

    /**
     * Setter for <code>rpkit.rpkit_locked_block.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_locked_block.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_locked_block.world</code>.
     */
    public void setWorld(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_locked_block.world</code>.
     */
    public String getWorld() {
        return (String) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_locked_block.x</code>.
     */
    public void setX(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_locked_block.x</code>.
     */
    public Integer getX() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>rpkit.rpkit_locked_block.y</code>.
     */
    public void setY(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_locked_block.y</code>.
     */
    public Integer getY() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>rpkit.rpkit_locked_block.z</code>.
     */
    public void setZ(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_locked_block.z</code>.
     */
    public Integer getZ() {
        return (Integer) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, Integer, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, Integer, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitLockedBlock.RPKIT_LOCKED_BLOCK.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return RpkitLockedBlock.RPKIT_LOCKED_BLOCK.WORLD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return RpkitLockedBlock.RPKIT_LOCKED_BLOCK.X;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return RpkitLockedBlock.RPKIT_LOCKED_BLOCK.Y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return RpkitLockedBlock.RPKIT_LOCKED_BLOCK.Z;
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
    public String component2() {
        return getWorld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getX();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getY();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getZ();
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
    public String value2() {
        return getWorld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getX();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getY();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getZ();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLockedBlockRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLockedBlockRecord value2(String value) {
        setWorld(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLockedBlockRecord value3(Integer value) {
        setX(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLockedBlockRecord value4(Integer value) {
        setY(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLockedBlockRecord value5(Integer value) {
        setZ(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitLockedBlockRecord values(Integer value1, String value2, Integer value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitLockedBlockRecord
     */
    public RpkitLockedBlockRecord() {
        super(RpkitLockedBlock.RPKIT_LOCKED_BLOCK);
    }

    /**
     * Create a detached, initialised RpkitLockedBlockRecord
     */
    public RpkitLockedBlockRecord(Integer id, String world, Integer x, Integer y, Integer z) {
        super(RpkitLockedBlock.RPKIT_LOCKED_BLOCK);

        set(0, id);
        set(1, world);
        set(2, x);
        set(3, y);
        set(4, z);
    }
}
