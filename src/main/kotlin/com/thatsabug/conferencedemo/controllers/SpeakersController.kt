package com.thatsabug.conferencedemo.controllers

import com.thatsabug.conferencedemo.models.Speaker
import com.thatsabug.conferencedemo.repositories.SpeakerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/speakers")
class SpeakersController (
    @Autowired val speakersRepository: SpeakerRepository
) {

    @GetMapping
    fun list() = speakersRepository.findAll()

    @GetMapping
    @RequestMapping("{id}")
    fun get(@PathVariable id: Long) =
        speakersRepository.getOne(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody speaker: Speaker) =
        speakersRepository.saveAndFlush(speaker)

    @RequestMapping(value = ["{id}"], method = [RequestMethod.DELETE])
    fun delete(@PathVariable id: Long) =
        speakersRepository.deleteById(id)
    // TODO - Delete Session_Schedule
    // TODO - Delete speaker if he/she doesn't have sessions

    @RequestMapping(value = ["{id}"], method = [RequestMethod.PUT])
    fun update(@PathVariable id: Long, @RequestBody newSpeaker: Speaker): Speaker {
        val oldSpeaker = speakersRepository.getOne(id)
        val updatedSpeaker = oldSpeaker.applySpeaker(newSpeaker)
        return speakersRepository.saveAndFlush(updatedSpeaker)
    }

    // TODO - Implement PATCH, so to update partially


}