package com.thatsabug.conferencedemo.repositories

import com.thatsabug.conferencedemo.models.Session
import org.springframework.data.jpa.repository.JpaRepository

interface SessionRepository : JpaRepository<Session, Long>