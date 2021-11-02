package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.geojson.PestFeatureCollection
import com.cip.agdxapi.core.service.CropPestDataService
import com.cip.agdxapi.database.entities.CropPestEntity
import com.cip.agdxapi.enums.EnumDetectionStatus
import com.cip.agdxapi.enums.EnumPestCategory
import com.cip.agdxapi.enums.EnumTreatmentStatus
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

@RequestMapping("api/v1/crop/pest")
@RestController
@Tag(name = "Crop pests", description = "Operations pertaining crop pests")
@SecurityRequirement(name = "api")
class CropPestDataController(private val cropPestDataService: CropPestDataService) {

    @PostMapping("/add")
    @Operation(summary = "Add new pest", description = "", tags = ["crop-pest"])
    fun addPestData(@RequestBody pestEntity: CropPestEntity): ResponseEntity<CropPestEntity> {
        val pestData = cropPestDataService.addPest(pestEntity = pestEntity)
        return ResponseEntity<CropPestEntity>(pestData, HttpStatus.OK)
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update crop pest record", description = "", tags = ["update-crop-pest"])
    fun updatePestData(
        @PathVariable id: Long,
        @RequestBody pestEntity: CropPestEntity
    ): ResponseEntity<CropPestEntity> {

        val pestData = cropPestDataService.addPest(pestEntity = pestEntity)

        return ResponseEntity<CropPestEntity>(pestData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of all pests", description = "", tags = ["crop-pest"])
    fun pestList(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<PestFeatureCollection> {
        val pestData = cropPestDataService.getPestList(pageable)

        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/{commonName}/common")
    @Operation(summary = "Get details of specific pest using its common name", description = "", tags = ["crop-pest"])
    fun getPestByCommonName(
        @PathVariable commonName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {

        val pestData = cropPestDataService.getPestByCommonName(commonName = commonName, pageable = pageable)

        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/{sccientificName}/scientific")
    @Operation(summary = "Get details of specific pest using its scientific name", description = "", tags = ["crop-pest"])
    fun getPestByScientificName(
        @PathVariable sccientificName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {

        val pestData = cropPestDataService.getPestByScientificName(scientificName = sccientificName)

        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "Get pest by category", description = "", tags = ["crop-pest"])
    fun getPestByCategory(
        @PathVariable category: ArrayList<EnumPestCategory>,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropPestEntity>> {
        val pestData: Page<CropPestEntity> = Page.empty()
        return ResponseEntity<Page<CropPestEntity>>(pestData, HttpStatus.OK)
    }

    @GetMapping("/habitat/{habitat}")
    @Operation(summary = "Get pests by habitat", description = "", tags = ["crop-pest"])
    fun getPestByHabitat(
        @PathVariable habitat: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropPestEntity>> {
        val pestData: Page<CropPestEntity> = Page.empty()
        return ResponseEntity<Page<CropPestEntity>>(pestData, HttpStatus.OK)
    }

    @GetMapping("/observe-date")
    @Operation(summary = "Find crop pests by observation date range", description = "", tags = ["date-crop-pest"])
    fun getPestsByObservedDate(
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {

        val pestData = cropPestDataService.getPestByObservedDate(fromDate = fromDate, toDate = toDate, pageable = pageable)

        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/reporting-date")
    @Operation(summary = "Find crop pests by reporting date range", description = "", tags = ["date-crop-pest"])
    fun getPestsByReportingDate(
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {

        val pestData = cropPestDataService.getPestByReportedDate(fromDate = fromDate, toDate = toDate, pageable = pageable)

        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/record-date")
    @Operation(summary = "Find crop pests by recording date range", description = "", tags = ["date-crop-pest"])
    fun getPestsByRecordingDate(
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate,
        @Parameter @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {

        val pestData = cropPestDataService.getPestByRecordingDate(fromDate = fromDate, toDate = toDate, pageable = pageable)

        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/crop-name/{cropName}")
    @Operation(summary = "Find crop pest by crop name", description = "", tags = ["crop-pest"])
    fun getPestsByCropName(
        @PathVariable cropName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {
        val pestData = cropPestDataService.getPestByCropName(cropName = cropName,pageable = pageable)
        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/cultivar/{cultivar}")
    @Operation(summary = "Find crop pest by cultivar type", description = "", tags = ["crop-pest"])
    fun getPestsByCultivarName(
        @PathVariable cultivar: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {
        val pestData = cropPestDataService.getPestByCultivar(cultivar = cultivar,pageable=pageable)
        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/detection-status/{status}")
    @Operation(summary = "Get pests by detection status", description = "", tags = ["status", "detection"])
    fun getPestByDetectionStatus(
        @PathVariable status: EnumDetectionStatus,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {
        val pestData = cropPestDataService.getPestByDetectionStatus(detectionStatus = status,pageable=pageable)
        return ResponseEntity(pestData, HttpStatus.OK)
    }


    @GetMapping("/management-status/{status}")
    @Operation(summary = "Get crop pests by management status", description = "", tags = ["status", "management"])
    fun getPestByManagementStatus(
        @PathVariable status: EnumTreatmentStatus,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {
        val pestData = cropPestDataService.getPestByTreatmentStatus(treatmentStatus = status,pageable=pageable)
        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/vector/{vector}")
    @Operation(summary = "Get pests by vector", description = "", tags = ["crop-pest"])
    fun getPestByVector(
        @PathVariable vector: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {
        val pestData = cropPestDataService.getPestByVector(vector = vector,pageable=pageable)
        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/admin-level/{adminLevel}/one")
    @Operation(summary = "Find crop pest by administration levels", description = "", tags = ["location-crop-pest"])
    fun getPestByAdminLevelOne(
        @PathVariable adminLevel: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {
        val pestData = cropPestDataService.getPestByAdminLevel(adminLevel = adminLevel,pageable=pageable)
        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/admin-level/{adminLevel}/two")
    @Operation(summary = "Find crop pest by administration levels", description = "", tags = ["location-crop-pest"])
    fun getPestByAdminLevelTwo(
        @PathVariable adminLevel: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {
        val pestData = cropPestDataService.getPestByAdminLevel(adminLevel = adminLevel,pageable=pageable)
        return ResponseEntity(pestData, HttpStatus.OK)
    }

    @GetMapping("/admin-level/{adminLevel}/three")
    @Operation(summary = "Find crop pest by administration levels", description = "", tags = ["location-crop-pest"])
    fun getPestByAdminLevelThree(
        @PathVariable adminLevel: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {
        val pestData = cropPestDataService.getPestByAdminLevel(adminLevel = adminLevel,pageable=pageable)
        return ResponseEntity(pestData, HttpStatus.OK)
    }
}
