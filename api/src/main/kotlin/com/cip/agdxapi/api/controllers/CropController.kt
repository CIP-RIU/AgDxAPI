package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.service.CropDataService
import com.cip.agdxapi.database.entities.CropEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//@RequestMapping("api/v1/crop")
//@RestController
//@Tag(name = "Crop data", description = "Operations pertaining crop")
//@SecurityRequirement(name = "api")
class CropController(val cropDataService: CropDataService) {


    @PostMapping("/add")
    @Operation(summary = "Add new crop", description = "", tags = ["add-crop"])
    fun addCropData(@RequestBody cropData: CropEntity): ResponseEntity<CropEntity> {

        return ResponseEntity<CropEntity>(CropEntity(), HttpStatus.OK)
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update crop record", description = "", tags = ["update-crop"])
    fun updateCropData(
        @PathVariable id: Long,
        @RequestBody cropData: CropEntity
    ): ResponseEntity<CropEntity> {
        val data = cropDataService.getCrop()
        return ResponseEntity<CropEntity>(data, HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of all crops", description = "", tags = ["crop"])
    fun getCropList(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<CropEntity>> {

        val cropData: Page<CropEntity> = cropDataService.getCrops(pageable = pageable)

        return ResponseEntity<Page<CropEntity>>(cropData, HttpStatus.OK)
    }

    @GetMapping("/{cropName}/common")
    @Operation(summary = "Get crops using common name", description = "", tags = ["crop"])
    fun getCropByCommonName(
        @PathVariable cropName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropEntity>> {

        val cropData: Page<CropEntity> = cropDataService.getCrops(pageable = pageable)

        return ResponseEntity<Page<CropEntity>>(cropData, HttpStatus.OK)
    }

    @GetMapping("/{cropName}/scientific")
    @Operation(summary = "Get crops using scientific name", description = "", tags = ["crop"])
    fun getCropByScientificName(
        @PathVariable cropName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<CropEntity> {
        val data = cropDataService.getCrop()
        return ResponseEntity<CropEntity>(data, HttpStatus.OK)
    }

    @GetMapping("/ontology/{ontologyId}")
    @Operation(summary = "Get crops using ontology id", description = "", tags = ["crop"])
    fun getCropByOntologyId(
        @PathVariable ontologyId: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<CropEntity> {
        val data = cropDataService.getCrop()
        return ResponseEntity<CropEntity>(data, HttpStatus.OK)
    }

    @GetMapping("/genus/{genus}")
    @Operation(summary = "Get crops using genus", description = "", tags = ["crop"])
    fun getCropByGenus(
        @PathVariable genus: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropEntity>> {

        val cropData: Page<CropEntity> = cropDataService.getCrops(pageable)

        return ResponseEntity<Page<CropEntity>>(cropData, HttpStatus.OK)
    }
//
//    @GetMapping("/order/{order}")
//    @Operation(summary = "Get crops by order", description = "", tags = ["crop"])
//    fun getCropByOrder(
//        @PathVariable order: String,
//        @Parameter(hidden = true) pageable: Pageable
//    ): ResponseEntity<Page<CropEntity>> {
//
//        val cropData: Page<CropEntity> = cropDataService.getCrops(pageable)
//
//        return ResponseEntity<Page<CropEntity>>(cropData, HttpStatus.OK)
//    }

    @GetMapping("/family/{family}")
    @Operation(summary = "Get crops using family", description = "", tags = ["crop"])
    fun getCropByFamily(
        @PathVariable family: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<CropEntity>> {

        val cropData: Page<CropEntity> = cropDataService.getCrops(pageable)

        return ResponseEntity<Page<CropEntity>>(cropData, HttpStatus.OK)
    }
}
