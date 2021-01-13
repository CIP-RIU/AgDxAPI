package com.cip.agdxapi.database.entities

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "common_data")
class CommonDataEntity : BaseEntity() {
    @Column(name = "lat", nullable = false)
    var lat: BigDecimal? = null

    @Column(name = "lon", nullable = false)
    var lon: BigDecimal? = null

    @Column(name = "alt", nullable = false)
    var alt: BigDecimal? = null

    @Column(name = "accuracy", nullable = false)
    var accuracy: BigDecimal? = null

    @Column(name = "country_code", nullable = false)
    var countryCode: String? = null

    @Column(name = "country_name", nullable = false)
    var countryName: String? = null

    @Column(name = "location_level1",columnDefinition = "TEXT")
    var locationLevel1: String? = null

    @Column(name = "location_level2",columnDefinition = "TEXT")
    var locationLevel2: String? = null

    @Column(name = "location_level3",columnDefinition = "TEXT")
    var locationLevel3: String? = null

    @Column(name = "date_reported")
    var dateReported: LocalDate? = null

    @Column(name = "date_updated")
    var dateUpdated: LocalDate? = null

    @Column(name = "date_reviewed")
    var dateReviewed: LocalDate? = null

    @Column(name = "ontology_name")
    var ontologyName: String? = null

    @Column(name = "common_name")
    var commonName: String? = null

    @Column(name = "scientific_name")
    var scientificName: String? = null

    @Column(name = "area_sampled")
    var areaSampled: BigDecimal? = null

    @Column(name = "affected_area")
    var affectedArea: BigDecimal? = null

    @Column(name = "area_unit")
    var areaUnit: String? = null

    @Column(name = "sample_source",columnDefinition = "TEXT")
    var sampleSource: String? = null

    @Column(name = "sample_desc",columnDefinition = "TEXT")
    var sampleDesc: String? = null

    @Column(name = "sample_size")
    var sampleSize: Int? = null

    @Column(name = "affected_sample_size")
    var affectedSampleSize: Int? = null

    @Column(name = "severity")
    var severity: Int? = null

    /**
     * whether detected or undetected
     */
    @Column(name = "occurrence_status")
    var occurrenceStatus: String? = null

    @Column(name = "comments", columnDefinition = "TEXT")
    var comments: String? = null

    @Column(name = "identification_method",columnDefinition = "TEXT")
    var identificationMethod: String? = null

    @Column(name = "data_collection_method")
    var dataCollectionMethod: String? = null

    @Column(name = "visually_identified")
    var visuallyIdentified: Boolean? = null

    @Column(name = "image_url")
    var imageUrl: String? = null

    @Column(name = "identified_by")
    var identifiedBy: String? = null
}