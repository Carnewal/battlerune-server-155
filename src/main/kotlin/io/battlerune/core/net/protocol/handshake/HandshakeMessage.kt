package io.battlerune.core.net.protocol.handshake

interface HandshakeMessage {

    val type: Int

    val response: Int

    companion object {
        val VERSION_CURRENT = 0
        val VERSION_EXPIRED = 6
    }

}