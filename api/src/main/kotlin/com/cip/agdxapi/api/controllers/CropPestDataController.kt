package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.geojson.PestFeatureCollection
import com.cip.agdxapi.core.service.CropPestDataService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/pests")
@RestController
@Tag(name = "Crop pests", description = "Operations pertaining crop pests")
class CropPestDataController(private val pestDataService: CropPestDataService) {

    @GetMapping("/{pestId}/occurrences")
    @Operation(description = "Return list of occurrences using pest id", tags = ["crop-disease-0"])
    fun cropDiseases(
        @PathVariable pestId: Long,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestFeatureCollection> {
        val diseaseData = pestDataService.occurrence(pestId = pestId, pageable = pageable)
        return ResponseEntity(diseaseData, HttpStatus.OK)
    }

}
