package com.thatsabug.conferencedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class ConferenceDemoApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
	runApplication<ConferenceDemoApplication>(*args)
}
