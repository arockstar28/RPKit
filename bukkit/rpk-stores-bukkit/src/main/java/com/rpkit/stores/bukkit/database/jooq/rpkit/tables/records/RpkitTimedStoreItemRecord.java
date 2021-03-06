/*
 * This file is generated by jOOQ.
 */
package com.rpkit.stores.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitTimedStoreItem;

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
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitTimedStoreItemRecord extends UpdatableRecordImpl<RpkitTimedStoreItemRecord> implements Record3<Integer, Integer, Long> {

    private static final long serialVersionUID = 1462825100;

    /**
     * Setter for <code>rpkit.rpkit_timed_store_item.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_timed_store_item.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_timed_store_item.store_item_id</code>.
     */
    public void setStoreItemId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_timed_store_item.store_item_id</code>.
     */
    public Integer getStoreItemId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_timed_store_item.duration</code>.
     */
    public void setDuration(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_timed_store_item.duration</code>.
     */
    public Long getDuration() {
        return (Long) get(2);
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
    public Row3<Integer, Integer, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM.STORE_ITEM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM.DURATION;
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
        return getStoreItemId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getDuration();
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
        return getStoreItemId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitTimedStoreItemRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitTimedStoreItemRecord value2(Integer value) {
        setStoreItemId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitTimedStoreItemRecord value3(Long value) {
        setDuration(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitTimedStoreItemRecord values(Integer value1, Integer value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitTimedStoreItemRecord
     */
    public RpkitTimedStoreItemRecord() {
        super(RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM);
    }

    /**
     * Create a detached, initialised RpkitTimedStoreItemRecord
     */
    public RpkitTimedStoreItemRecord(Integer id, Integer storeItemId, Long duration) {
        super(RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM);

        set(0, id);
        set(1, storeItemId);
        set(2, duration);
    }
}
