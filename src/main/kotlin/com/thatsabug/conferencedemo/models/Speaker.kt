package com.thatsabug.conferencedemo.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "speakers")
data class Speaker(
    @Id @GeneratedValue
    val speaker_id: Long = 0,
    val first_name: String = "",
    val last_name: String = "",
    val speaker_bio: String = "",
    val title: String = "",
    val company: String = "",

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    val speaker_photo: ByteArray? = null,

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnoreProperties("speakers")
    val sessions: List<Session> = mutableListOf()
)