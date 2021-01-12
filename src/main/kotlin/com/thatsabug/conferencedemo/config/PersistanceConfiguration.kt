package com.thatsabug.conferencedemo.config

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class PersistenceConfiguration {
//    @Bean
//    fun dataSource() : DataSource =
//        DataSourceBuilder.create()
//            .url("jdbc:postgresql://localhost:5432/conference_app")
//            .username("postgres")
//            .password("Welcome")
//            .build()
}