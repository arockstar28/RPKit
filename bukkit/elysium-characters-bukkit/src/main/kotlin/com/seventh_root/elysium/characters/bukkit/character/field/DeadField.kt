package com.seventh_root.elysium.characters.bukkit.character.field

import com.seventh_root.elysium.characters.bukkit.character.field.CharacterCardField
import com.seventh_root.elysium.characters.bukkit.character.ElysiumCharacter

class DeadField: CharacterCardField {

    override val name = "dead"
    override fun get(character: ElysiumCharacter): String {
        return character.isDead.toString()
    }


}