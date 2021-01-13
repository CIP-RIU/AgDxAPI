package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.dto.DiseaseDataDto
import com.cip.agdxapi.core.service.DiseaseDataService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/disease")
@RestController
@Tag(name = "Crop disease data", description = "Operations pertaining crop disease data")
class DiseaseDataController(val diseaseDataService: DiseaseDataService) {

    @PostMapping
    @Operation(summary = "Add new diseases record", description = "", tags = ["disease"])
    fun addPestData(@RequestBody diseaseDataDto: DiseaseDataDto): ResponseEntity<DiseaseDataDto> {

        val pestData: DiseaseDataDto = diseaseDataService.addDiseaseData(diseaseData = diseaseDataDto)

        return ResponseEntity<DiseaseDataDto>(pestData, HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of all diseases", description = "", tags = ["disease"])
    fun getPestData(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<DiseaseDataDto>> {

        val diseaseData: Page<DiseaseDataDto> = diseaseDataService.getDiseaseData(pageable = pageable)

        return ResponseEntity<Page<DiseaseDataDto>>(diseaseData, HttpStatus.OK)
    }
}