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

package com.seventh_root.elysium.chat.bukkit.context

import com.seventh_root.elysium.chat.bukkit.chatchannel.ElysiumChatChannel
import com.seventh_root.elysium.players.bukkit.player.ElysiumPlayer

/**
 * An undirected chat channel message context.
 * Stores data for messages passed through a chat channel's undirected pipeline.
 */
interface UndirectedChatChannelMessageContext {

    /**
     * The chat channel the message is being sent to.
     */
    val chatChannel: ElysiumChatChannel

    /**
     * The sender of the message.
     */
    val sender: ElysiumPlayer

    /**
     * The message. Changing the message results in the updated message being propagated to all further pipeline
     * components.
     */
    var message: String

    /**
     * Whether the message has been cancelled.
     * If the message is cancelled, further pipeline components may choose whether they still  wish to operate on the
     * message or not.
     */
    var isCancelled: Boolean

}
