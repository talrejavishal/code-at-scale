package com.codebetteratscale.shedlock_demo.config

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT5S") // ISO-8601 duration
class SchedulerConfig
