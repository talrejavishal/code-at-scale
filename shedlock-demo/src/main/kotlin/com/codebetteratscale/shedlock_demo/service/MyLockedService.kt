package com.codebetteratscale.shedlock_demo.service

import net.javacrumbs.shedlock.core.LockConfiguration
import net.javacrumbs.shedlock.core.LockProvider
import net.javacrumbs.shedlock.core.SimpleLock
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.Instant
import java.util.Optional
import java.util.concurrent.Executors

@Service
class MyLockedService(
    private val lockProvider: LockProvider
) {

    fun demoManualLockWithThreads() {
        val executor = Executors.newFixedThreadPool(10)

        repeat(10) { i ->
            executor.submit {
                val threadName = "Thread-$i"
                performLockedTask(threadName)
            }
        }

        executor.shutdown()
    }

    private fun performLockedTask(threadName: String) {
        val lockName = "MyOnDemandTask"
        val lockAtMostFor = Duration.ofSeconds(30)
        val lockAtLeastFor = Duration.ofSeconds(5)

        val maybeLock: Optional<SimpleLock?> = lockProvider.lock(
            LockConfiguration(
                Instant.now(),
                "custom-lock-task",
                lockAtMostFor,
                lockAtLeastFor)
        )

        if(maybeLock.isPresent){
            println("[$threadName] Acquired lock. Executing task...")
            Thread.sleep(3000) // Simulate work
            println("[$threadName] Task completed.")
        }else{
            println("[$threadName] Couldn't acquire lock, Skipping")
        }
    }
}