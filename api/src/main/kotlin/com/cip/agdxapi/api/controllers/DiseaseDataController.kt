package com.cip.agdxapi.api.controllers

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("api/v1/disease")
@RestController
@Tag(name = "Crop disease data", description = "Operations pertaining crop disease data")
class DiseaseDataController {

    @GetMapping
    fun verifyAccount(): ResponseEntity<String> {
        return ResponseEntity<String>("Return crop disease here", HttpStatus.OK)
    }
}