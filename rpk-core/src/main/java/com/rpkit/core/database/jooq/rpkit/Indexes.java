/*
 * This file is generated by jOOQ.
*/
package com.rpkit.core.database.jooq.rpkit;


import com.rpkit.core.database.jooq.rpkit.tables.TableVersion;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>rpkit</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index TABLE_VERSION_PRIMARY = Indexes0.TABLE_VERSION_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index TABLE_VERSION_PRIMARY = createIndex("PRIMARY", TableVersion.TABLE_VERSION, new OrderField[] { TableVersion.TABLE_VERSION.ID }, true);
    }
}
