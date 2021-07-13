package com.cip.agdxapi.database.entities

import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Pertains to crop data
 */
@Entity
@Table(name = "crop")
class CropEntity : BaseEntity() {

    @Column(name = "common_name")
    @Schema(description = "Crop common name", example = "Banana")
    var commonName: String? = null

    @Column(name = "scientific_name")
    @Schema(description = "Crop scientific name", example = "Musca")
    var scientificName: String? = null

    @Column(name = "ontology_id")
    @Schema(description = "Ontology id of the crop", example = "C350")
    var ontologyId: String? = null

    @Column(name = "genus")
    @Schema(description = "Genus crop", example = "Musa")
    var genus: String? = null

    @Column(name = "family")
    @Schema(description = "Family crop", example = "Musaceae")
    var family: String? = null
}
