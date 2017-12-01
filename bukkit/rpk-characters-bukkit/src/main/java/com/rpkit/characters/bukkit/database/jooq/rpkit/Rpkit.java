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
package com.rpkit.characters.bukkit.database.jooq.rpkit;


import com.rpkit.characters.bukkit.database.jooq.DefaultCatalog;
import com.rpkit.characters.bukkit.database.jooq.rpkit.tables.PlayerCharacter;
import com.rpkit.characters.bukkit.database.jooq.rpkit.tables.RpkitCharacter;
import com.rpkit.characters.bukkit.database.jooq.rpkit.tables.RpkitGender;
import com.rpkit.characters.bukkit.database.jooq.rpkit.tables.RpkitNewCharacterCooldown;
import com.rpkit.characters.bukkit.database.jooq.rpkit.tables.RpkitRace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Rpkit extends SchemaImpl {

    private static final long serialVersionUID = 1772231932;

    /**
     * The reference instance of <code>rpkit</code>
     */
    public static final Rpkit RPKIT = new Rpkit();

    /**
     * The table <code>rpkit.player_character</code>.
     */
    public final PlayerCharacter PLAYER_CHARACTER = PlayerCharacter.PLAYER_CHARACTER;

    /**
     * The table <code>rpkit.rpkit_character</code>.
     */
    public final RpkitCharacter RPKIT_CHARACTER = RpkitCharacter.RPKIT_CHARACTER;

    /**
     * The table <code>rpkit.rpkit_gender</code>.
     */
    public final RpkitGender RPKIT_GENDER = RpkitGender.RPKIT_GENDER;

    /**
     * The table <code>rpkit.rpkit_new_character_cooldown</code>.
     */
    public final RpkitNewCharacterCooldown RPKIT_NEW_CHARACTER_COOLDOWN = RpkitNewCharacterCooldown.RPKIT_NEW_CHARACTER_COOLDOWN;

    /**
     * The table <code>rpkit.rpkit_race</code>.
     */
    public final RpkitRace RPKIT_RACE = RpkitRace.RPKIT_RACE;

    /**
     * No further instances allowed
     */
    private Rpkit() {
        super("rpkit", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            PlayerCharacter.PLAYER_CHARACTER,
            RpkitCharacter.RPKIT_CHARACTER,
            RpkitGender.RPKIT_GENDER,
            RpkitNewCharacterCooldown.RPKIT_NEW_CHARACTER_COOLDOWN,
            RpkitRace.RPKIT_RACE);
    }
}
