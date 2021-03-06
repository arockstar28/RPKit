/*
 * Copyright 2017 Ross Binden
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
package com.rpkit.payments.bukkit.database.jooq.rpkit;


import com.rpkit.payments.bukkit.database.jooq.rpkit.tables.RpkitPaymentGroup;
import com.rpkit.payments.bukkit.database.jooq.rpkit.tables.RpkitPaymentGroupInvite;
import com.rpkit.payments.bukkit.database.jooq.rpkit.tables.RpkitPaymentGroupMember;
import com.rpkit.payments.bukkit.database.jooq.rpkit.tables.RpkitPaymentGroupOwner;
import com.rpkit.payments.bukkit.database.jooq.rpkit.tables.RpkitPaymentNotification;

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
     * The table <code>rpkit.rpkit_payment_group</code>.
     */
    public static final RpkitPaymentGroup RPKIT_PAYMENT_GROUP = RpkitPaymentGroup.RPKIT_PAYMENT_GROUP;

    /**
     * The table <code>rpkit.rpkit_payment_group_invite</code>.
     */
    public static final RpkitPaymentGroupInvite RPKIT_PAYMENT_GROUP_INVITE = RpkitPaymentGroupInvite.RPKIT_PAYMENT_GROUP_INVITE;

    /**
     * The table <code>rpkit.rpkit_payment_group_member</code>.
     */
    public static final RpkitPaymentGroupMember RPKIT_PAYMENT_GROUP_MEMBER = RpkitPaymentGroupMember.RPKIT_PAYMENT_GROUP_MEMBER;

    /**
     * The table <code>rpkit.rpkit_payment_group_owner</code>.
     */
    public static final RpkitPaymentGroupOwner RPKIT_PAYMENT_GROUP_OWNER = RpkitPaymentGroupOwner.RPKIT_PAYMENT_GROUP_OWNER;

    /**
     * The table <code>rpkit.rpkit_payment_notification</code>.
     */
    public static final RpkitPaymentNotification RPKIT_PAYMENT_NOTIFICATION = RpkitPaymentNotification.RPKIT_PAYMENT_NOTIFICATION;
}
