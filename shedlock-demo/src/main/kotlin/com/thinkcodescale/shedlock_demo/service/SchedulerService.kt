package com.thinkcodescale.shedlock_demo.service

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class SchedulerService {
    @Scheduled(cron = "*/2 * * * * *")
    @SchedulerLock(name = "myScheduledTask", lockAtLeastFor = "PT1S")
    fun run() {
        println("🔁 Running task at ${java.time.LocalDateTime.now()}")
    }
}