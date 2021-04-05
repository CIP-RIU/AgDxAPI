package com.cip.agdxapi.database.entities

import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.*


/**
 * Pertains to crop cultivar data
 */
@Entity
@Table(name = "crop_cultivar")
class CropCultivarEntity : BaseEntity() {

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "crop_id", referencedColumnName = "id")
    var cropName: CropEntity? = null

    @Column(name = "common_name")
    @Schema(description = "Crop cultivar", example = "TMS 90257")
    var commonName: String? = null

    @Column(name = "cultivar_name")
    @Schema(description = "Crop cultivar", example = "TMS 90257")
    var cultivarName: String? = null

//    @OneToMany(mappedBy = "cultivar")
//    var cropDiseases: Set<CropDiseaseEntity>? = null
}