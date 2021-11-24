package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.geojson.DiseaseFeatureCollection
import com.cip.agdxapi.core.service.CropDiseaseDataService
import com.cip.agdxapi.database.entities.CropDiseaseEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Pageable
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RequestMapping("api/v1/crops")
@RestController
@Tag(name = "Crop diseases", description = "Operations pertaining crop disease")
@SecurityRequirement(name = "api")
class CropDiseaseDataController(val cropDiseaseDataService: CropDiseaseDataService) {

    @PostMapping("/disease/{cropId}/add")
    @Operation(summary = "Add disease to the database using crop id", description = "", tags = ["crop-disease"])
    fun addDiseaseData(
        @PathVariable cropId: Long,
        @RequestBody cropDiseaseData: CropDiseaseEntity
    ): ResponseEntity<CropDiseaseEntity> {

        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)

        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
    }

    @PutMapping("/disease/{diseaseId}/update")
    @Operation(summary = "Update crop disease record", description = "", tags = ["crop-disease"])
    fun updateDiseaseData(
        @PathVariable diseaseId: Long,
        @RequestBody cropDiseaseData: CropDiseaseEntity
    ): ResponseEntity<CropDiseaseEntity> {

        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)

        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
    }

    @GetMapping("/diseases/{cropId}")
    @Operation(summary = "Return list of diseases using crop id", description = "", tags = ["crop-disease-0"])
    fun cropDiseases(
        @PathVariable cropId: Long,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getCropDisease(cropId = cropId, pageable = pageable)
        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/diseases/{cropId}/cultivar/{cultivarId}")
    @Operation(summary = "Return list of diseases using crop id and cultivar id", description = "", tags = ["crop-disease-1"])
    fun cropDiseasesByCultivar(
        @PathVariable cropId: Long,
        @PathVariable cultivarId: Long,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getCropDisease(cropId = cultivarId, pageable = pageable)
        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/disease/{cropId}/observation-date")
    @Operation(summary = "Find a crop disease using crop id and a specified date range", description = "", tags = ["crop-disease-0"])
    fun cropDiseaseByRecordedDate(
        @PathVariable cropId: Long,
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData =
            cropDiseaseDataService.getCropDiseasesByRecordedDate(cropId = cropId, fromDate = fromDate, toDate = toDate, pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/disease/{cropId}/country-code/{countryCode}")
    @Operation(summary = "Find a crop disease using crop id and country code", description = "", tags = ["crop-disease-0"])
    fun cropDiseaseByCountryCode(
        @PathVariable cropId: Long,
        @PathVariable countryCode: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getCropDiseasesByCountryCode(
            cropId = cropId,
            countryCode = countryCode,
            pageable = pageable
        )

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/disease/{cropId}/country-code/{countryCode}")
    @Operation(summary = "Find a crop disease using crop id and country code", description = "", tags = ["crop-disease-0"])
    fun cropDiseaseByLocations(
        @PathVariable cropId: Long,
        @PathVariable countryCode: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getCropDiseasesByCountryCode(
            cropId = cropId,
            countryCode = countryCode,
            pageable = pageable
        )

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }
}
