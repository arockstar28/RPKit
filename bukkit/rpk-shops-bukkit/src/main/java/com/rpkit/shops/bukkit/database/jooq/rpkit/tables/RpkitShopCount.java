/*
 * This file is generated by jOOQ.
*/
package com.rpkit.shops.bukkit.database.jooq.rpkit.tables;


import com.rpkit.shops.bukkit.database.jooq.rpkit.Indexes;
import com.rpkit.shops.bukkit.database.jooq.rpkit.Keys;
import com.rpkit.shops.bukkit.database.jooq.rpkit.Rpkit;
import com.rpkit.shops.bukkit.database.jooq.rpkit.tables.records.RpkitShopCountRecord;

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
public class RpkitShopCount extends TableImpl<RpkitShopCountRecord> {

    private static final long serialVersionUID = 892706157;

    /**
     * The reference instance of <code>rpkit.rpkit_shop_count</code>
     */
    public static final RpkitShopCount RPKIT_SHOP_COUNT = new RpkitShopCount();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitShopCountRecord> getRecordType() {
        return RpkitShopCountRecord.class;
    }

    /**
     * The column <code>rpkit.rpkit_shop_count.id</code>.
     */
    public final TableField<RpkitShopCountRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit.rpkit_shop_count.character_id</code>.
     */
    public final TableField<RpkitShopCountRecord, Integer> CHARACTER_ID = createField("character_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>rpkit.rpkit_shop_count.count</code>.
     */
    public final TableField<RpkitShopCountRecord, Integer> COUNT = createField("count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>rpkit.rpkit_shop_count</code> table reference
     */
    public RpkitShopCount() {
        this(DSL.name("rpkit_shop_count"), null);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_shop_count</code> table reference
     */
    public RpkitShopCount(String alias) {
        this(DSL.name(alias), RPKIT_SHOP_COUNT);
    }

    /**
     * Create an aliased <code>rpkit.rpkit_shop_count</code> table reference
     */
    public RpkitShopCount(Name alias) {
        this(alias, RPKIT_SHOP_COUNT);
    }

    private RpkitShopCount(Name alias, Table<RpkitShopCountRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitShopCount(Name alias, Table<RpkitShopCountRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.RPKIT_SHOP_COUNT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RpkitShopCountRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_SHOP_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RpkitShopCountRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_SHOP_COUNT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RpkitShopCountRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitShopCountRecord>>asList(Keys.KEY_RPKIT_SHOP_COUNT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitShopCount as(String alias) {
        return new RpkitShopCount(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RpkitShopCount as(Name alias) {
        return new RpkitShopCount(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitShopCount rename(String name) {
        return new RpkitShopCount(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitShopCount rename(Name name) {
        return new RpkitShopCount(name, null);
    }
}
