package com.thatsabug.conferencedemo.controllers

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/version")
class VersionController {
    @Value("\${app.version}")
    private lateinit var version: String

    @GetMapping
    fun version() = mapOf("app-version" to version)
}