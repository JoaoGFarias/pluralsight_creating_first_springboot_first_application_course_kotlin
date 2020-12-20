package com.thatsabug.conferencedemo.controllers

import com.fasterxml.jackson.databind.util.BeanUtil
import com.thatsabug.conferencedemo.models.Session
import com.thatsabug.conferencedemo.repositories.SessionRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody session: Session) =
        sessionRepository.saveAndFlush(session)

    @RequestMapping(value = ["{id}"], method = [RequestMethod.DELETE])
    fun delete(@PathVariable id: Long) =
        sessionRepository.deleteById(id)
        // TODO - Delete speaker if he/she doesn't have sessions

    @RequestMapping(value = ["{id}"], method = [RequestMethod.PUT])
    fun update(@PathVariable id: Long, @RequestBody newSession: Session): Session {
        val oldSession = sessionRepository.getOne(id)
        val updatedSpeaker = oldSession.applySession(newSession)
        return sessionRepository.saveAndFlush(updatedSpeaker)
    }

    // TODO - Implement PATCH, so to update partially
}