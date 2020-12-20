package com.thatsabug.conferencedemo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "sessions")
data class  Session (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val session_id: Long = 0,
    val session_name: String = "",
    val session_description: String ="",
    val session_length: Int = 0,

    @ManyToMany
    @JoinTable(name = "session_speakers",
        joinColumns = [JoinColumn(name = idAttribute)],
        inverseJoinColumns = [JoinColumn(name = Speaker.idAttribute)])
    @JsonIgnoreProperties("sessions")
    val speakers: List<Speaker> = mutableListOf()
) {

    fun applySession(newSession: Session) =
        Session(
            session_id = session_id,
            session_name = newSession.session_name,
            session_description = newSession.session_description,
            session_length = newSession.session_length,
            speakers = newSession.speakers,
        )

    companion object {
        const val idAttribute: String = "session_id"
    }
}