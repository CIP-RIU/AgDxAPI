package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.service.CropDiseaseDataService
import com.cip.agdxapi.database.entities.CropDiseaseEntity
import com.cip.agdxapi.enums.EnumNameType
import com.cip.agdxapi.enums.EnumNativity
import com.cip.agdxapi.enums.EnumStatus
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RequestMapping("api/v2/crop/disease")
@RestController
@Tag(name = "Crop disease data", description = "Operations pertaining crop disease data")
//@SecurityRequirement(name = "api")
class CropDiseaseDataController(val cropDiseaseDataService: CropDiseaseDataService) {

//    @PostMapping
//    @Operation(summary = "Add new crop disease record", description = "", tags = ["crop-disease"])
//    fun addPestData(@RequestBody cropDiseaseData: CropDiseaseEntity): ResponseEntity<CropDiseaseEntity> {
//
//        val pestData = cropDiseaseDataService.addCropDisease(cropDiseaseData = cropDiseaseData)
//
//        return ResponseEntity<CropDiseaseEntity>(pestData, HttpStatus.OK)
//    }

    @GetMapping
    @Operation(summary = "Return list of all diseases", description = "", tags = ["crop-disease"])
    fun getDiseaseList(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/disease-name")
    @Operation(summary = "Get details of specific disease using its common/scientific name", description = "", tags = ["crop-disease"])
    fun getDiseaseByCommonName(
        @Parameter diseaseName: String,
        @Parameter nameType: EnumNameType,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/country/{countryCode}")
    @Operation(summary = "Find crop disease by country name", description = "", tags = ["crop-disease"])
    fun getDiseaseByCountry(
        @PathVariable countryCode: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/observe-date/{fromDate}/to/{toDate}")
    @Operation(summary = "Find crop disease by observation date range", description = "", tags = ["crop-disease"])
    fun getDiseaseByObservedDate(
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/reporting-date/{fromDate}/to/{toDate}")
    @Operation(summary = "Find crop disease by reporting date range", description = "", tags = ["crop-disease"])
    fun getDiseaseByReportingDate(
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/record-date/{fromDate}/to/{toDate}")
    @Operation(summary = "Find crop disease by recording date range", description = "", tags = ["crop-disease"])
    fun getDiseaseByRecordingDate(
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/crop-name/{cropName}")
    @Operation(summary = "Find crop disease by crop name", description = "", tags = ["crop-disease"])
    fun getDiseaseByCropName(
        @PathVariable cropName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {
        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)
        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/cultivar/{cultivar}")
    @Operation(summary = "Find crop disease by cultivar", description = "", tags = ["crop-disease"])
    fun getDiseaseByCultivarName(
        @PathVariable cultivar: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {
        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)
        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    @GetMapping("/verification-method/{verificationMethod}")
    @Operation(summary = "Find crop disease by verification methods", description = "", tags = ["crop-disease"])
    fun getDiseaseByVerificationMethod(
        @PathVariable verificationMethod: ArrayList<String>,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {
        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)
        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

    //pathogens

    @GetMapping("/pathogen")
    @Operation(summary = "search disease using its pathogen attributes", description = "", tags = ["crop-disease"])
    fun getDiseaseByCommonPathogenName(
        @Parameter name: String?,
        @Parameter(examples = [EnumNameType.COMMON]) nameType: EnumNameType?,
        @Parameter nativity: EnumNativity?,
        @Parameter status: EnumStatus?,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropDiseaseEntity>> {

        val diseaseData: Page<CropDiseaseEntity> = cropDiseaseDataService.getDiseaseData(pageable = pageable)
        return ResponseEntity<Page<CropDiseaseEntity>>(diseaseData, HttpStatus.OK)
    }

}