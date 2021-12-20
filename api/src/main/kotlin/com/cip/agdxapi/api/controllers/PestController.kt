package com.cip.agdxapi.api.controllers

import com.cip.agdxapi.core.service.PestDataService
import com.cip.agdxapi.database.entities.PestEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/pests")
@RestController
@Tag(name = "Pest data", description = "Operations pertaining pests")
class PestController(val pestDataService: PestDataService) {

    @PostMapping("/add")
    @Operation(description = "Add new pest", tags = ["add-pest"])
    fun addPestData(@RequestBody pestData: PestEntity): ResponseEntity<PestEntity> {

        return ResponseEntity<PestEntity>(PestEntity(), HttpStatus.OK)
    }

    @PutMapping("/update/{id}")
    @Operation(description = "Update pest record", tags = ["update-pest"])
    fun updatePestData(
        @PathVariable id: Long,
        @RequestBody pestData: PestEntity
    ): ResponseEntity<PestEntity> {

        return ResponseEntity<PestEntity>(PestEntity(), HttpStatus.OK)
    }

    @GetMapping
    @Operation(description = "Return list of all pests", tags = ["pest"])
    fun getPestList(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<PestEntity>> {

        val pestData = pestDataService.getPests(pageable = pageable)

        return ResponseEntity<Page<PestEntity>>(pestData, HttpStatus.OK)
    }
}
