package com.cip.agdxapi.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.util.*

@SpringBootApplication
@ComponentScan("com.cip.agdxapi")
@EntityScan("com.cip.agdxapi.database.entities")
@EnableJpaRepositories("com.cip.agdxapi.database.repos")
class AgDxApiApp {
    @Bean
    fun restTemplate(): RestTemplate? {
        val restTemplate = RestTemplate()
        val messageConverters: MutableList<HttpMessageConverter<*>> = ArrayList()
        val converter = MappingJackson2HttpMessageConverter()
        converter.supportedMediaTypes = Collections.singletonList(MediaType.ALL)
        messageConverters.add(converter)
        restTemplate.messageConverters = messageConverters
        return restTemplate
    }
}

fun main(args: Array<String>) {
    runApplication<AgDxApiApp>(*args)
}
