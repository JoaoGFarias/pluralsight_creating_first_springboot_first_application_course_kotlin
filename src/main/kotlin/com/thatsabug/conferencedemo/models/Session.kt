package com.thatsabug.conferencedemo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "sessions")
data class Session (
    @Id @GeneratedValue
    val session_id: Long = 0,
    val session_name: String = "",
    val session_description: String ="",
    val session_length: Int = 0,

    @ManyToMany
    @JoinTable(name = "session_speakers",
        joinColumns = [JoinColumn(name = "session_id")],
        inverseJoinColumns = [JoinColumn(name = "speaker_id")])
    @JsonIgnoreProperties("sessions")
    val speakers: List<Speaker> = mutableListOf()
)