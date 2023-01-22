package dev.mvillasenor.japaneselearner.data

import dev.mvillasenor.japanesetrainer.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TestSync(
    private val networkClient: NetworkClient,
    private val subjectsRepository: SubjectsRepository,
) {
    suspend fun runInitialSync() = withContext(Dispatchers.IO) {
        val result = networkClient.getRadicals()
        result.onSuccess { radicals ->
            subjectsRepository.insertRadicals(radicals = radicals)
        }
    }
}