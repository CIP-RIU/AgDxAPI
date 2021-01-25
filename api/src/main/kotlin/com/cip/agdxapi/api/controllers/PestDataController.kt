package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.dto.PestDataDto
import com.cip.agdxapi.core.service.PestDataService
import com.cip.agdxapi.database.entities.CropPestEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/crop/pest")
@RestController
@Tag(name = "Crop pest data", description = "Operations pertaining crop pest data")
@SecurityRequirement(name = "api")
class PestDataController(private val pestDataService: PestDataService) {

    @PostMapping
    @Operation(summary = "Add new pest", description = "", tags = ["pest"])
    fun addPestData(@RequestBody pestEntity: CropPestEntity): ResponseEntity<CropPestEntity> {

        val pestData = pestDataService.addPestData(pestEntity = pestEntity)

        return ResponseEntity<CropPestEntity>(pestData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of all pests", description = "", tags = ["pest"])
    fun getPestData(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<CropPestEntity>> {

        val pestData: Page<CropPestEntity> = pestDataService.getPestData(pageable)

        return ResponseEntity<Page<CropPestEntity>>(pestData, HttpStatus.OK)
    }
}