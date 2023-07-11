package com.cip.agdxapi.database.entities

import com.cip.agdxapi.enums.EnumPestCategory
import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.*

/**
 * Pertains to pest data
 */
@Entity
@Table(name = "pest")
class PestEntity : BaseEntity() {


    @Column(name = "common_name")
    @Schema(description = "Pest common name", example = "Wooly apple aphid")
    var commonName: String? = null

    @Column(name = "scientific_name")
    @Schema(description = "Pest scientific name", example = "Eriosoma lanigerum")
    var scientificName: String? = null


    @Column(name = "order")
    @Schema(description = "Pest order", example = "Hemiptera")
    var order: String? = null

    @Column(name = "family")
    @Schema(description = "Pest family", example = "Aphididae")
    var family: String? = null

    @Column(name = "genus")
    @Schema(description = "Pest genus", example = "Eriosoma")
    var genus: String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    @Schema(description = "Pest family", example = "Insect")
    var category: EnumPestCategory? = null
}
