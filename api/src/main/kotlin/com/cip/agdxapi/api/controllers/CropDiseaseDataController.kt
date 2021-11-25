package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.geojson.DiseaseFeatureCollection
import com.cip.agdxapi.core.request.CoordinateRequest
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
@Tag(name = "Crop diseases", description = "Operations pertaining to disease of a specific crop")
@SecurityRequirement(name = "api")
class CropDiseaseDataController(val cropDiseaseDataService: CropDiseaseDataService) {

    @GetMapping("/{cropId}/diseases")
    @Operation(summary = "Return list of diseases using crop id", description = "", tags = ["crop-disease-0"])
    fun cropDiseases(
        @PathVariable cropId: Long,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getCropDisease(cropId = cropId, pageable = pageable)
        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{cropId}/cultivar/{cultivarId}/diseases")
    @Operation(summary = "Return list of diseases using crop id and cultivar id", description = "", tags = ["crop-disease-1"])
    fun cropDiseasesByCultivar(
        @PathVariable cropId: Long,
        @PathVariable cultivarId: Long,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getCropDisease(cropId = cultivarId, pageable = pageable)
        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{cropId}/diseases/observation-date")
    @Operation(summary = "Return list of diseases using crop id and a specified observation date range", description = "", tags = ["crop-disease-0"])
    fun cropDiseaseByObservationDate(
        @PathVariable cropId: Long,
        @Parameter(example = "2020-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @Parameter(example = "2021-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData =
            cropDiseaseDataService.getCropDiseasesByObservedDate(cropId = cropId, fromDate = fromDate, toDate = toDate, pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{cropId}/diseases/recording-date")
    @Operation(summary = "Return list of diseases using crop id and a specified recorded date range", description = "", tags = ["crop-disease-0"])
    fun cropDiseaseByRecordedDate(
        @PathVariable cropId: Long,
        @Parameter(example = "2020-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @Parameter(example = "2021-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData =
            cropDiseaseDataService.getCropDiseasesByRecordedDate(cropId = cropId, fromDate = fromDate, toDate = toDate, pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{cropId}/diseases/country-code")
    @Operation(summary = "Return list of diseases using crop id and country codes", description = "", tags = ["crop-disease-0"])
    fun cropDiseaseByCountryCode(
        @PathVariable cropId: Long,
        @Parameter(example = "CO,KE") countryCode: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val countryCodes: List<String> = countryCode.split(",")
        val diseaseData = cropDiseaseDataService.getCropDiseasesByCountryCode(
            cropId = cropId,
            countryCode = countryCodes,
            pageable = pageable
        )

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

//    @GetMapping("/{cropId}/diseases/coordinates")
//    @Operation(summary = "Return list of diseases using crop id and array of coordinates", description = "", tags = ["crop-disease-0"])
//    fun cropDiseaseByLocations(
//        @PathVariable cropId: Long,
//        @Parameter coordinates: List<CoordinateRequest>,
//        @Parameter(hidden = true) pageable: Pageable
//    ): ResponseEntity<DiseaseFeatureCollection> {
//
//
//        val diseaseData = cropDiseaseDataService.getCropDiseasesByCountryCode(
//            cropId = cropId,
//            countryCode = "",
//            pageable = pageable
//        )
//
//        return ResponseEntity(diseaseData, HttpStatus.OK)
//    }

    @GetMapping("/{cropId}/diseases/project")
    @Operation(summary = "Return list of diseases using crop id and project name", description = "", tags = ["crop-disease-2"])
    fun cropDiseaseByProject(
        @PathVariable cropId: Long,
        @Parameter(example = "PestDisplace") projectName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getCropDiseasesByProjectName(
            cropId = cropId,
            projectName = projectName,
            pageable = pageable
        )

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }
}
