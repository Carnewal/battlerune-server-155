package io.battlerune.net.login

import io.battlerune.net.codec.handshake.HandshakeMessage

class LoginHandshakeMessage(override val type: Int, override val response: Int) : HandshakeMessage {}