package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.geojson.DiseaseFeatureCollection
import com.cip.agdxapi.core.service.CropDiseaseDataService
import com.cip.agdxapi.database.entities.CropDiseaseEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RequestMapping("api/v1/crop/disease")
@RestController
@Tag(name = "Crop diseases", description = "Operations pertaining crop disease")
@SecurityRequirement(name = "api")
class CropDiseaseDataController(val cropDiseaseDataService: CropDiseaseDataService) {

    @PostMapping("/add")
    @Operation(summary = "Add new crop pest record", description = "", tags = ["add-crop-disease"])
    fun addPestData(@RequestBody cropDiseaseData: CropDiseaseEntity): ResponseEntity<CropDiseaseEntity> {

        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)

        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update crop disease record", description = "", tags = ["update-crop-disease"])
    fun updatePestData(
        @PathVariable id: Long,
        @RequestBody cropDiseaseData: CropDiseaseEntity
    ): ResponseEntity<CropDiseaseEntity> {

        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)

        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of all diseases", description = "", tags = ["crop-disease"])
    fun getDiseaseList(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{diseaseName}/common")
    @Operation(summary = "Get details of specific disease using its common name", description = "", tags = ["crop-disease"])
    fun getDiseaseByCommonName(
        @PathVariable diseaseName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/{diseaseName}/scientific")
    @Operation(summary = "Get details of specific disease using its scientific name", description = "", tags = ["crop-disease"])
    fun getDiseaseByScientificName(
        @PathVariable diseaseName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/observe-date")
    @Operation(summary = "Find crop disease by observation date range", description = "", tags = ["date-crop-disease"])
    fun getDiseaseByObservedDate(
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/reporting-date")
    @Operation(summary = "Find crop disease by reporting date range", description = "", tags = ["date-crop-disease"])
    fun getDiseaseByReportingDate(
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/record-date")
    @Operation(summary = "Find crop disease by recording date range", description = "", tags = ["date-crop-disease"])
    fun getDiseaseByRecordingDate(
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/crop-name/{cropName}")
    @Operation(summary = "Find crop disease by crop name", description = "", tags = ["crop-disease"])
    fun getDiseaseByCropName(
        @PathVariable cropName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/cultivar/{cultivar}")
    @Operation(summary = "Find crop disease by cultivar type", description = "", tags = ["crop-disease"])
    fun getDiseaseByCultivarName(
        @PathVariable cultivar: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/verification-method/{verificationMethod}")
    @Operation(summary = "Find crop disease by verification methods", description = "", tags = ["crop-disease"])
    fun getDiseaseByVerificationMethod(
        @PathVariable verificationMethod: ArrayList<String>,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/pathogen/{name}/common")
    @Operation(summary = "Get list of diseases by common pathogen names", description = "Search parameters are optional", tags = ["crop-disease"])
    fun getDiseaseByCommonPathogen(
        @PathVariable name: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/pathogen/{name}/scientific")
    @Operation(summary = "Get list of diseases by scientific pathogen name ", description = "Search parameters are optional", tags = ["crop-disease"])
    fun getDiseaseByScientificPathogen(
        @PathVariable name: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/genebank/{accessionNumber}")
    @Operation(summary = "Get list of diseases by genebank number", description = "Search can be partial", tags = ["gene-crop-disease"])
    fun getDiseaseByGeneBankNumber(
        @PathVariable accessionNumber: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }


    @GetMapping("/project/{project}")
    @Operation(summary = "Get list of diseases by project name", description = "", tags = ["gene-crop-disease"])
    fun getDiseaseByProjectName(
        @PathVariable project: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {
        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/country/{countryCode}")
    @Operation(summary = "Find crop diseases by country code", description = "", tags = ["location-crop-disease"])
    fun getDiseaseByCountry(
        @PathVariable countryCode: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/admin-level/{adminName}/one")
    @Operation(summary = "Find crop diseases by administration levels", description = "", tags = ["location-crop-disease"])
    fun getDiseaseByAdminLevelOne(
        @PathVariable adminName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/admin-level/{adminName}/two")
    @Operation(summary = "Find crop diseases by administration levels", description = "", tags = ["location-crop-disease"])
    fun getDiseaseByAdminLevelTwo(
        @PathVariable adminName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/admin-level/{adminName}/three")
    @Operation(summary = "Find crop diseases by administration levels", description = "", tags = ["location-crop-disease"])
    fun getDiseaseByAdminLevelThree(
        @PathVariable adminName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<DiseaseFeatureCollection> {

        val diseaseData = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

}
