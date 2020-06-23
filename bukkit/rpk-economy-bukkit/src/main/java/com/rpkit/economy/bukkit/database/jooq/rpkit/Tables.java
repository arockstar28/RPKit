/*
 * Copyright 2020 Ren Binden
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

/*
 * This file is generated by jOOQ.
*/
package com.rpkit.economy.bukkit.database.jooq.rpkit;


import com.rpkit.economy.bukkit.database.jooq.rpkit.tables.MoneyHidden;
import com.rpkit.economy.bukkit.database.jooq.rpkit.tables.RpkitCurrency;
import com.rpkit.economy.bukkit.database.jooq.rpkit.tables.RpkitWallet;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in rpkit
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>rpkit.money_hidden</code>.
     */
    public static final MoneyHidden MONEY_HIDDEN = MoneyHidden.MONEY_HIDDEN;

    /**
     * The table <code>rpkit.rpkit_currency</code>.
     */
    public static final RpkitCurrency RPKIT_CURRENCY = RpkitCurrency.RPKIT_CURRENCY;

    /**
     * The table <code>rpkit.rpkit_wallet</code>.
     */
    public static final RpkitWallet RPKIT_WALLET = RpkitWallet.RPKIT_WALLET;
}
