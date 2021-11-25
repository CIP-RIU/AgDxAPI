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
class DiseaseController(val cropDiseaseDataService: CropDiseaseDataService) {

    @PostMapping("/add")
    @Operation(description = "Add disease to the database", tags = ["disease"])
    fun addDiseaseData(
        @RequestBody cropDiseaseData: CropDiseaseEntity
    ): ResponseEntity<CropDiseaseEntity> {

        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)

        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
    }

    @PutMapping("/{diseaseId}")
    @Operation(description = "Update disease record", tags = ["disease-0"])
    fun updateDiseaseData(
        @PathVariable diseaseId: Long,
        @RequestBody cropDiseaseData: CropDiseaseEntity
    ): ResponseEntity<CropDiseaseEntity> {

        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)

        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
    }

    @GetMapping("/{diseaseId}")
    @Operation(description = "Return details of single disease using diseaseId", tags = ["disease-1"])
    fun getDiseaseDetails(
        @Parameter(example = "1") @PathVariable diseaseId: Long
    ): ResponseEntity<CropDiseaseEntity> {
        val diseaseData = cropDiseaseDataService.getSingleCropDisease(diseaseId = diseaseId)
        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(description = "Return list of diseases in the database", tags = ["disease-1"])
    fun cropDiseases(
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getCropDisease(cropId = 0, pageable = pageable)
        return ResponseEntity(diseaseData, HttpStatus.OK)
    }


    @GetMapping("/{projectName}/project")
    @Operation(description = "Return list of diseases using project name", tags = ["disease-2"])
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
    @Operation(description = "Return list of diseases using country codes", tags = ["disease-2"])
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
