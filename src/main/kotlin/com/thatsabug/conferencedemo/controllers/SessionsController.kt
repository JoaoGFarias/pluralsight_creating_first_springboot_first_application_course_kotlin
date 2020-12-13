package com.thatsabug.conferencedemo.controllers

import com.thatsabug.conferencedemo.repositories.SessionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sessions")
class SessionsController (
    @Autowired val sessionRepository: SessionRepository
) {

    @GetMapping
    fun list() = sessionRepository.findAll()

    @GetMapping
    @RequestMapping("{id}")
    fun get(@PathVariable id: Long) =
        sessionRepository.getOne(id)


}