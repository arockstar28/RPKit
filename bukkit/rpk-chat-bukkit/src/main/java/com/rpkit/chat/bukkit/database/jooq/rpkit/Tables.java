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
package com.rpkit.chat.bukkit.database.jooq.rpkit;


import com.rpkit.chat.bukkit.database.jooq.rpkit.tables.ChatGroupInvite;
import com.rpkit.chat.bukkit.database.jooq.rpkit.tables.ChatGroupMember;
import com.rpkit.chat.bukkit.database.jooq.rpkit.tables.LastUsedChatGroup;
import com.rpkit.chat.bukkit.database.jooq.rpkit.tables.RpkitChatChannelMute;
import com.rpkit.chat.bukkit.database.jooq.rpkit.tables.RpkitChatChannelSpeaker;
import com.rpkit.chat.bukkit.database.jooq.rpkit.tables.RpkitChatGroup;
import com.rpkit.chat.bukkit.database.jooq.rpkit.tables.RpkitSnooper;

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
     * The table <code>rpkit.chat_group_invite</code>.
     */
    public static final ChatGroupInvite CHAT_GROUP_INVITE = ChatGroupInvite.CHAT_GROUP_INVITE;

    /**
     * The table <code>rpkit.chat_group_member</code>.
     */
    public static final ChatGroupMember CHAT_GROUP_MEMBER = ChatGroupMember.CHAT_GROUP_MEMBER;

    /**
     * The table <code>rpkit.last_used_chat_group</code>.
     */
    public static final LastUsedChatGroup LAST_USED_CHAT_GROUP = LastUsedChatGroup.LAST_USED_CHAT_GROUP;

    /**
     * The table <code>rpkit.rpkit_chat_channel_mute</code>.
     */
    public static final RpkitChatChannelMute RPKIT_CHAT_CHANNEL_MUTE = RpkitChatChannelMute.RPKIT_CHAT_CHANNEL_MUTE;

    /**
     * The table <code>rpkit.rpkit_chat_channel_speaker</code>.
     */
    public static final RpkitChatChannelSpeaker RPKIT_CHAT_CHANNEL_SPEAKER = RpkitChatChannelSpeaker.RPKIT_CHAT_CHANNEL_SPEAKER;

    /**
     * The table <code>rpkit.rpkit_chat_group</code>.
     */
    public static final RpkitChatGroup RPKIT_CHAT_GROUP = RpkitChatGroup.RPKIT_CHAT_GROUP;

    /**
     * The table <code>rpkit.rpkit_snooper</code>.
     */
    public static final RpkitSnooper RPKIT_SNOOPER = RpkitSnooper.RPKIT_SNOOPER;
}
