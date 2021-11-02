package com.cip.agdxapi.api.controllers

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

@RequestMapping("api/v1/pest")
@RestController
@Tag(name = "Pest data", description = "Operations pertaining pests")
//@SecurityRequirement(name = "api")
class PestController {

    @PostMapping("/add")
    @Operation(summary = "Add new pest", description = "", tags = ["add-pest"])
    fun addPestData(@RequestBody pestData: PestEntity): ResponseEntity<PestEntity> {

        return ResponseEntity<PestEntity>(PestEntity(), HttpStatus.OK)
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update pest record", description = "", tags = ["update-pest"])
    fun updatePestData(
        @PathVariable id: Long,
        @RequestBody pestData: PestEntity
    ): ResponseEntity<PestEntity> {

        return ResponseEntity<PestEntity>(PestEntity(), HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Return list of all pests", description = "", tags = ["pest"])
    fun getPestList(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<PestEntity>> {

        val pestData: Page<PestEntity> = Page.empty()

        return ResponseEntity<Page<PestEntity>>(pestData, HttpStatus.OK)
    }

    @GetMapping("/{pestName}/common")
    @Operation(summary = "Get pests using common name", description = "", tags = ["pest"])
    fun getPestByCommonName(
        @PathVariable pestName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<PestEntity>> {

        val pestData: Page<PestEntity> = Page.empty()

        return ResponseEntity<Page<PestEntity>>(pestData, HttpStatus.OK)
    }

    @GetMapping("/{pestName}/scientific")
    @Operation(summary = "Get pests using scientific name", description = "", tags = ["pest"])
    fun getPestByScientificName(
        @PathVariable pestName: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<PestEntity> {

        return ResponseEntity<PestEntity>(PestEntity(), HttpStatus.OK)
    }

    @GetMapping("/order/{order}")
    @Operation(summary = "Get pests using order", description = "", tags = ["pest"])
    fun getPestByOrder(
        @PathVariable order: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<PestEntity>> {

        val pestData: Page<PestEntity> = Page.empty()

        return ResponseEntity<Page<PestEntity>>(pestData, HttpStatus.OK)
    }

    @GetMapping("/family/{family}")
    @Operation(summary = "Get pests using family", description = "", tags = ["pest"])
    fun getPestByFamily(
        @PathVariable family: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<PestEntity>> {

        val pestData: Page<PestEntity> = Page.empty()

        return ResponseEntity<Page<PestEntity>>(pestData, HttpStatus.OK)
    }

    @GetMapping("/genus/{genus}")
    @Operation(summary = "Get pests using genus", description = "", tags = ["pest"])
    fun getPestByGenus(
        @PathVariable genus: String,
        @Parameter(hidden = true) pageable: Pageable
    ): ResponseEntity<Page<PestEntity>> {

        val pestData: Page<PestEntity> = Page.empty()

        return ResponseEntity<Page<PestEntity>>(pestData, HttpStatus.OK)
    }
}
