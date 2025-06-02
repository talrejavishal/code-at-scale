package com.codebetteratscale.shedlock_demo.service

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SchedulerService {
    @Scheduled(cron = "*/2 * * * * *")
    @SchedulerLock(name = "myScheduledTask", lockAtLeastFor = "PT1S")
    fun run() {
        println("🔁 Running task at ${LocalDateTime.now()}")
    }
}