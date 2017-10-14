package io.battlerune.net.packet.`in`

import io.battlerune.game.event.impl.ButtonClickEvent
import io.battlerune.game.world.actor.pawn.player.Player
import io.battlerune.net.codec.game.RSByteBufReader
import io.battlerune.net.packet.PacketDecoder

class ButtonClickPacketDecoder : PacketDecoder<ButtonClickEvent> {

    override fun decode(player: Player, reader: RSByteBufReader) : ButtonClickEvent {
        val value = reader.readInt()
        val interfaceId = value shr 16
        val buttonId = value and 0xFFFF
        return ButtonClickEvent(player, interfaceId, buttonId)
    }

}