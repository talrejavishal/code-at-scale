//package com.thinkcodescale.shedlock_demo.service
//
//import kotlinx.coroutines.*
//import net.javacrumbs.shedlock.core.LockConfiguration
//import net.javacrumbs.shedlock.core.LockManager
//import net.javacrumbs.shedlock.core.SimpleLock
//import org.springframework.stereotype.Service
//import java.time.Duration
//import java.time.Instant
//
//@Service
//class MyLockedService(private val lockManager: LockManager) {
//
//    suspend fun runWithManualLockCoroutineSafe(coroutineName: String) {
//        val lockConfig = LockConfiguration(
//            "multi-thread-lock",
//            Instant.now().plus(Duration.ofSeconds(30)) // lockAtMostFor
//        )
//
//        val lock: SimpleLock? = lockManager.lock(lockConfig).orElse(null)
//
//        lock?.use {
//            println("[$coroutineName] ✅ Lock acquired. Running critical section...")
//            delay(3000) // Suspend instead of blocking
//            println("[$coroutineName] 🔓 Finished work, releasing lock.")
//        } ?: run {
//            println("[$coroutineName] ❌ Could not acquire lock. Skipping execution.")
//        }
//    }
//
//    fun testWithCoroutines() = runBlocking {
//        val jobs = List(5) { i ->
//            launch(Dispatchers.IO) {
//                runWithManualLockCoroutineSafe("Coroutine-$i")
//            }
//        }
//
//        jobs.joinAll()
//    }
//}
