/*
 * Copyright 2018 Ross Binden
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

package com.rpkit.store.bukkit.purchase

import com.rpkit.store.bukkit.storeitem.RPKConsumableStoreItem

/**
 * Represents a consumable purchase.
 * A consumable purchase has a limited number of uses.
 */
interface RPKConsumablePurchase: RPKPurchase {

    /**
     * The store item that has been purchased
     */
    override val storeItem: RPKConsumableStoreItem

    /**
     * The remaining uses of the purchase.
     * If this reaches 0, the purchase may no longer be used.
     */
    var remainingUses: Int

}