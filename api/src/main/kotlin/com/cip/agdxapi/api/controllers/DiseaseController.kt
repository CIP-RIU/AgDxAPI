package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.geojson.DiseaseFeatureCollection
import com.cip.agdxapi.core.service.CropDiseaseDataService
import com.cip.agdxapi.database.entities.CropDiseaseEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/diseases")
@RestController
@Tag(name = "Diseases", description = "Operations pertaining to all crop diseases")
@SecurityRequirement(name = "api")
class DiseaseController(val cropDiseaseDataService: CropDiseaseDataService) {

    @PostMapping("/add")
    @Operation(summary = "Add disease to the database", description = "", tags = ["disease"])
    fun addDiseaseData(
        @RequestBody cropDiseaseData: CropDiseaseEntity
    ): ResponseEntity<CropDiseaseEntity> {

        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)

        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
    }

    @PutMapping("/{diseaseId}")
    @Operation(summary = "Update disease record", description = "", tags = ["disease"])
    fun updateDiseaseData(
        @PathVariable diseaseId: Long,
        @RequestBody cropDiseaseData: CropDiseaseEntity
    ): ResponseEntity<CropDiseaseEntity> {

        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)

        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of diseases in the database", description = "", tags = ["disease-0"])
    fun cropDiseases(
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getCropDisease(cropId = 0, pageable = pageable)
        return ResponseEntity(diseaseData, HttpStatus.OK)
    }


    @GetMapping("/{projectName}/project")
    @Operation(summary = "Return list of diseases using project name", description = "", tags = ["disease-2"])
    fun cropDiseasesByProject(
        @Parameter(example = "PestDisplace") @PathVariable projectName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getCropDiseasesByProjectName(
            projectName = projectName,
            pageable = pageable
        )

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{countryCode}/country")
    @Operation(summary = "Return list of diseases using country codes", description = "", tags = ["disease-2"])
    fun cropDiseasesByCountry(
        @Parameter(example = "CO,KE,NG") @PathVariable countryCode: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val countries = countryCode.split(",")
        val diseaseData = cropDiseaseDataService.getCropDiseasesByCountryCode(
            countryCodes = countries,
            pageable = pageable
        )

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }
}
