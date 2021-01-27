package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.service.CropPestDataService
import com.cip.agdxapi.database.entities.CropDiseaseEntity
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
//@SecurityRequirement(name = "api")
class CropPestDataController(private val cropPestDataService: CropPestDataService) {

    @PostMapping
    @Operation(summary = "Add new pest", description = "", tags = ["crop-pest"])
    fun addPestData(@RequestBody pestEntity: CropPestEntity): ResponseEntity<CropPestEntity> {

        val pestData = cropPestDataService.addPestData(pestEntity = pestEntity)

        return ResponseEntity<CropPestEntity>(pestData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of all pests", description = "", tags = ["crop-pest"])
    fun getPestData(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<CropPestEntity>> {

        val pestData: Page<CropPestEntity> = cropPestDataService.getPestData(pageable)

        return ResponseEntity<Page<CropPestEntity>>(pestData, HttpStatus.OK)
    }

    @GetMapping("/{pestName}/common")
    @Operation(summary = "Get details of specific pest using its common name", description = "", tags = ["crop-pest"])
    fun getPestByCommonName(
        @PathVariable pestName: String,
//        @PageableAsQueryParam(par),
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropPestEntity>> {

        val diseaseData: Page<CropPestEntity> = cropPestDataService.getPestData(pageable = pageable)

        return ResponseEntity<Page<CropPestEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{pestName}/scientific")
    @Operation(summary = "Get details of specific pest using its scientific name", description = "", tags = ["crop-pest"])
    fun getPestByScientificName(
        @PathVariable pestName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropPestEntity>> {

        val diseaseData: Page<CropPestEntity> = cropPestDataService.getPestData(pageable = pageable)

        return ResponseEntity<Page<CropPestEntity>>(diseaseData, HttpStatus.OK)
    }
}