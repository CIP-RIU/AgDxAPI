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
@SecurityRequirement(name = "api")
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
    @Operation(summary = "Return list of all crops in the database", description = "", tags = ["crop"])
    fun allCrops(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<CropEntity>> {

        val cropData: Page<CropEntity> = cropDataService.getCrops(pageable = pageable)

        return ResponseEntity<Page<CropEntity>>(cropData, HttpStatus.OK)
    }
}
