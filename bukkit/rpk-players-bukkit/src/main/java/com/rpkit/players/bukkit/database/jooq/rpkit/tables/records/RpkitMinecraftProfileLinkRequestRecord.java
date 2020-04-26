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
package com.rpkit.players.bukkit.database.jooq.rpkit.tables.records;


import com.rpkit.players.bukkit.database.jooq.rpkit.tables.RpkitMinecraftProfileLinkRequest;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitMinecraftProfileLinkRequestRecord extends UpdatableRecordImpl<RpkitMinecraftProfileLinkRequestRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 1381677797;

    /**
     * Setter for <code>rpkit.rpkit_minecraft_profile_link_request.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_minecraft_profile_link_request.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit.rpkit_minecraft_profile_link_request.profile_id</code>.
     */
    public void setProfileId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_minecraft_profile_link_request.profile_id</code>.
     */
    public Integer getProfileId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>rpkit.rpkit_minecraft_profile_link_request.minecraft_profile_id</code>.
     */
    public void setMinecraftProfileId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit.rpkit_minecraft_profile_link_request.minecraft_profile_id</code>.
     */
    public Integer getMinecraftProfileId() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitMinecraftProfileLinkRequest.RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.ID;
    }

    @Override
    public Field<Integer> field2() {
        return RpkitMinecraftProfileLinkRequest.RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.PROFILE_ID;
    }

    @Override
    public Field<Integer> field3() {
        return RpkitMinecraftProfileLinkRequest.RPKIT_MINECRAFT_PROFILE_LINK_REQUEST.MINECRAFT_PROFILE_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getProfileId();
    }

    @Override
    public Integer component3() {
        return getMinecraftProfileId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getProfileId();
    }

    @Override
    public Integer value3() {
        return getMinecraftProfileId();
    }

    @Override
    public RpkitMinecraftProfileLinkRequestRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public RpkitMinecraftProfileLinkRequestRecord value2(Integer value) {
        setProfileId(value);
        return this;
    }

    @Override
    public RpkitMinecraftProfileLinkRequestRecord value3(Integer value) {
        setMinecraftProfileId(value);
        return this;
    }

    @Override
    public RpkitMinecraftProfileLinkRequestRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitMinecraftProfileLinkRequestRecord
     */
    public RpkitMinecraftProfileLinkRequestRecord() {
        super(RpkitMinecraftProfileLinkRequest.RPKIT_MINECRAFT_PROFILE_LINK_REQUEST);
    }

    /**
     * Create a detached, initialised RpkitMinecraftProfileLinkRequestRecord
     */
    public RpkitMinecraftProfileLinkRequestRecord(Integer id, Integer profileId, Integer minecraftProfileId) {
        super(RpkitMinecraftProfileLinkRequest.RPKIT_MINECRAFT_PROFILE_LINK_REQUEST);

        set(0, id);
        set(1, profileId);
        set(2, minecraftProfileId);
    }
}
