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

@RequestMapping("api/v1/crops")
@RestController
@Tag(name = "Crops", description = "Operations pertaining to crops")
class CropController(val cropDataService: CropDataService) {


    @PostMapping("/add-new")
    @Operation(description = "Add new crop",  tags = ["add-crop"])
    fun addCropData(@RequestBody cropData: CropEntity): ResponseEntity<CropEntity> {
        val data = cropDataService.addCrop(cropData)
        return ResponseEntity<CropEntity>(data, HttpStatus.OK)
    }

    @PutMapping("/update/{cropId}")
    @Operation(description = "Update crop record",  tags = ["update-crop"])
    fun updateCropData(
        @PathVariable cropId: Long,
        @RequestBody cropData: CropEntity
    ): ResponseEntity<CropEntity> {
        val data = cropDataService.getCrop(cropId)
        return ResponseEntity<CropEntity>(data, HttpStatus.OK)
    }

    @GetMapping("/{cropId}")
    @Operation(description = "Return crop data using crop id",  tags = ["crop"])
    fun crop(@PathVariable cropId: Long): ResponseEntity<CropEntity> {

        val cropData: CropEntity? = cropDataService.getCrop(cropId)

        return ResponseEntity<CropEntity>(cropData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(description = "Return list of all crops in the database",  tags = ["crop"])
    fun allCrops(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<CropEntity>> {

        val cropData: Page<CropEntity> = cropDataService.getCrops(pageable = pageable)

        return ResponseEntity<Page<CropEntity>>(cropData, HttpStatus.OK)
    }
}
