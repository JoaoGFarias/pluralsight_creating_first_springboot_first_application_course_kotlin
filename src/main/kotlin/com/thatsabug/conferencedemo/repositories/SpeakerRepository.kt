package com.thatsabug.conferencedemo.repositories

import com.thatsabug.conferencedemo.models.Speaker
import org.hibernate.Session
import org.springframework.data.jpa.repository.JpaRepository

interface SpeakerRepository : JpaRepository<Speaker, Long>