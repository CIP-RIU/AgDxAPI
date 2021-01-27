package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.dto.DiseaseDataDto
import com.cip.agdxapi.core.service.CropDiseaseDataService
import com.cip.agdxapi.database.entities.CropDiseaseEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springdoc.core.converters.models.PageableAsQueryParam
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/crop/disease")
@RestController
@Tag(name = "Crop disease data", description = "Operations pertaining crop disease data")
//@SecurityRequirement(name = "api")
class CropDiseaseDataController(val cropDiseaseDataService: CropDiseaseDataService) {

    @PostMapping
    @Operation(summary = "Add new crop disease record", description = "", tags = ["crop-disease"])
    fun addPestData(@RequestBody cropDiseaseData: CropDiseaseEntity): ResponseEntity<CropDiseaseEntity> {

        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)

        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of all diseases", description = "", tags = ["crop-disease"])
    fun getDiseaseList(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{diseaseName}/common")
    @Operation(summary = "Get details of specific disease using its common name", description = "", tags = ["crop-disease"])
    fun getDiseaseByCommonName(
        @PathVariable diseaseName: String,
//        @PageableAsQueryParam(par),
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{diseaseName}/scientific")
    @Operation(summary = "Get details of specific disease using its scientific name", description = "", tags = ["crop-disease"])
    fun getDiseaseByScientificName(
        @PathVariable diseaseName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }
}