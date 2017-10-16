package io.battlerune.game.service

import io.battlerune.game.GameContext
import io.battlerune.io.RegionLoader
import io.battlerune.io.FileSystemLoader
import io.battlerune.io.HuffmanLoader
import io.battlerune.io.PacketRepositoryLoader
import io.battlerune.net.NetworkConstants
import io.battlerune.net.NetworkService

class StartupService {

    private val context = GameContext()

    private val startupService = StartupTaskService()
    private val gameService = GameService(context)
    private val networkService = NetworkService(context)

    private fun processStartupTasks() {
        startupService.queue(PacketRepositoryLoader())
                .queue(FileSystemLoader(context))
                .queue(RegionLoader(context))
                .queue(HuffmanLoader(context))
    }

    fun start() {
        processStartupTasks()
        startupService.start()
        startupService.awaitUntilFinished()
        gameService.startAsync()
        networkService.start(NetworkConstants.PORT)
    }

    // TODO implement eventually
    fun restart() {

    }

}