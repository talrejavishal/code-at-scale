package com.codeatscale.shedlock_demo.controller

import com.codeatscale.shedlock_demo.service.MyLockedService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lock-demo")
class LockDemoController(
    private val manualLockService: MyLockedService
) {

    @PostMapping
    fun runLockDemo(): String {
        manualLockService.demoManualLockWithThreads()
        return "Threads started"
    }
}
