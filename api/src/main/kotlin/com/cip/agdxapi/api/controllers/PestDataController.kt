package com.cip.agdxapi.api.controllers

import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("api/v1/pest")
@RestController
@Api(value = "Pest Data", description = "Operations pertaining Pest Data")
class PestDataController {

    @GetMapping
    fun verifyAccount(): ResponseEntity<String> {
        return ResponseEntity<String>("Hello there", HttpStatus.OK)
    }
}