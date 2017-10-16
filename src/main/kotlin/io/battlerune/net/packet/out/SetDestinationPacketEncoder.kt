package io.battlerune.net.packet.out

import io.battlerune.game.world.Position
import io.battlerune.game.world.actor.pawn.player.Player
import io.battlerune.net.codec.game.RSByteBufWriter
import io.battlerune.net.packet.Packet
import io.battlerune.net.packet.PacketEncoder
import io.battlerune.net.packet.PacketType

class SetDestinationPacketEncoder(val position: Position) : PacketEncoder {

    override fun encode(player: Player): Packet {
        val writer = RSByteBufWriter.alloc(2)
        writer.writeByte(position.regionX)
                .writeByte(position.regionY)
        return writer.toPacket(88, PacketType.FIXED)
    }

}