package com.thatsabug.conferencedemo.controllers

import com.thatsabug.conferencedemo.repositories.SpeakerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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


}