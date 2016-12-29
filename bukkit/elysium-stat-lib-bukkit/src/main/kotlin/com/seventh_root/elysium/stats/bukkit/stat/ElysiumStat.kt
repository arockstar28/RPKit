/*
 * Copyright 2016 Ross Binden
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

package com.seventh_root.elysium.stats.bukkit.stat

import com.seventh_root.elysium.characters.bukkit.character.ElysiumCharacter
import com.seventh_root.elysium.core.database.Entity

/**
 * Represents a stat.
 */
interface ElysiumStat: Entity {

    /**
     * The name of the stat.
     */
    val name: String

    /**
     * The script used to calculate the stat.
     * Written in JavaScript, parsed with Nashorn.
     */
    val script: String

    /**
     * Gets the stat for the given character, and the given stat variables.
     *
     * @param character The character
     * @param variables A list containing all variables required to get the stat.
     *                  Usually [ElysiumStatVariableProvider.statVariables]
     */
    fun get(character: ElysiumCharacter, variables: List<ElysiumStatVariable>): Int

}
