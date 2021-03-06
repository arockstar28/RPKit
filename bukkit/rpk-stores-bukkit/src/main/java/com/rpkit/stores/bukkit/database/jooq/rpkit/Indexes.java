/*
 * This file is generated by jOOQ.
 */
package com.rpkit.stores.bukkit.database.jooq.rpkit;


import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitConsumablePurchase;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitConsumableStoreItem;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitPermanentPurchase;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitPermanentStoreItem;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitPurchase;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitStoreItem;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitTimedPurchase;
import com.rpkit.stores.bukkit.database.jooq.rpkit.tables.RpkitTimedStoreItem;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>rpkit</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index RPKIT_CONSUMABLE_PURCHASE_PRIMARY = Indexes0.RPKIT_CONSUMABLE_PURCHASE_PRIMARY;
    public static final Index RPKIT_CONSUMABLE_STORE_ITEM_PRIMARY = Indexes0.RPKIT_CONSUMABLE_STORE_ITEM_PRIMARY;
    public static final Index RPKIT_PERMANENT_PURCHASE_PRIMARY = Indexes0.RPKIT_PERMANENT_PURCHASE_PRIMARY;
    public static final Index RPKIT_PERMANENT_STORE_ITEM_PRIMARY = Indexes0.RPKIT_PERMANENT_STORE_ITEM_PRIMARY;
    public static final Index RPKIT_PURCHASE_PRIMARY = Indexes0.RPKIT_PURCHASE_PRIMARY;
    public static final Index RPKIT_STORE_ITEM_PRIMARY = Indexes0.RPKIT_STORE_ITEM_PRIMARY;
    public static final Index RPKIT_TIMED_PURCHASE_PRIMARY = Indexes0.RPKIT_TIMED_PURCHASE_PRIMARY;
    public static final Index RPKIT_TIMED_STORE_ITEM_PRIMARY = Indexes0.RPKIT_TIMED_STORE_ITEM_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index RPKIT_CONSUMABLE_PURCHASE_PRIMARY = Internal.createIndex("PRIMARY", RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE, new OrderField[] { RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE.ID }, true);
        public static Index RPKIT_CONSUMABLE_STORE_ITEM_PRIMARY = Internal.createIndex("PRIMARY", RpkitConsumableStoreItem.RPKIT_CONSUMABLE_STORE_ITEM, new OrderField[] { RpkitConsumableStoreItem.RPKIT_CONSUMABLE_STORE_ITEM.ID }, true);
        public static Index RPKIT_PERMANENT_PURCHASE_PRIMARY = Internal.createIndex("PRIMARY", RpkitPermanentPurchase.RPKIT_PERMANENT_PURCHASE, new OrderField[] { RpkitPermanentPurchase.RPKIT_PERMANENT_PURCHASE.ID }, true);
        public static Index RPKIT_PERMANENT_STORE_ITEM_PRIMARY = Internal.createIndex("PRIMARY", RpkitPermanentStoreItem.RPKIT_PERMANENT_STORE_ITEM, new OrderField[] { RpkitPermanentStoreItem.RPKIT_PERMANENT_STORE_ITEM.ID }, true);
        public static Index RPKIT_PURCHASE_PRIMARY = Internal.createIndex("PRIMARY", RpkitPurchase.RPKIT_PURCHASE, new OrderField[] { RpkitPurchase.RPKIT_PURCHASE.ID }, true);
        public static Index RPKIT_STORE_ITEM_PRIMARY = Internal.createIndex("PRIMARY", RpkitStoreItem.RPKIT_STORE_ITEM, new OrderField[] { RpkitStoreItem.RPKIT_STORE_ITEM.ID }, true);
        public static Index RPKIT_TIMED_PURCHASE_PRIMARY = Internal.createIndex("PRIMARY", RpkitTimedPurchase.RPKIT_TIMED_PURCHASE, new OrderField[] { RpkitTimedPurchase.RPKIT_TIMED_PURCHASE.ID }, true);
        public static Index RPKIT_TIMED_STORE_ITEM_PRIMARY = Internal.createIndex("PRIMARY", RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM, new OrderField[] { RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM.ID }, true);
    }
}
