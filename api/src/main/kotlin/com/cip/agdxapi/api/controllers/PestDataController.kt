package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.dto.PestDataDto
import com.cip.agdxapi.core.service.PestDataService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/pest")
@RestController
@Tag(name = "Crop pest data", description = "Operations pertaining crop pest data")
@SecurityRequirement(name = "api")
class PestDataController(private val pestDataService: PestDataService) {

    @PostMapping
    @Operation(summary = "Add new pest", description = "", tags = ["pest"])
    fun addPestData(@RequestBody pestDataDto: PestDataDto): ResponseEntity<PestDataDto> {

        val pestData: PestDataDto = pestDataService.addPestData(pestData = pestDataDto)

        return ResponseEntity<PestDataDto>(pestData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of all pests", description = "", tags = ["pest"])
    fun getPestData(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<PestDataDto>> {

        val pestData: Page<PestDataDto> = pestDataService.getPestData(pageable)

        return ResponseEntity<Page<PestDataDto>>(pestData, HttpStatus.OK)
    }
}