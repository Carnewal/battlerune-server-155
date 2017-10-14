package io.battlerune.net.packet.out

import io.battlerune.game.world.actor.pawn.player.Player
import io.battlerune.net.codec.game.RSByteBufWriter
import io.battlerune.net.packet.Packet
import io.battlerune.net.packet.PacketType
import io.battlerune.net.packet.PacketEncoder

class InterfaceTextPacketEncoder(private val root: Int, private val child: Int, private val message: String) : PacketEncoder {

    override fun encode(player: Player): Packet {
        val writer = RSByteBufWriter.alloc()
        writer.writeInt((root shl 16) or child)
        .writeString(message)
        return writer.toPacket(42, PacketType.VAR_SHORT)
    }

}