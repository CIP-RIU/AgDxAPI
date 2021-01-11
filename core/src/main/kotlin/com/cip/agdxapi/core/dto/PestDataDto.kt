package com.cip.agdxapi.core.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@JsonInclude(JsonInclude.Include.NON_NULL)
class PestDataDto {
    @JsonProperty("lat")
    var lat: BigDecimal? = null

    @JsonProperty("lon")
    var lon: BigDecimal? = null

    @JsonProperty("alt")
    var alt: BigDecimal? = null

    @JsonProperty("accuracy")
    var accuracy: BigDecimal? = null

    @JsonProperty("country_code")
    var countryCode: String? = null

    @JsonProperty("country_name")
    var countryName: String? = null

    @JsonProperty("location_level1")
    var locationLevel1: String? = null

    @JsonProperty("location_level2")
    var locationLevel2: String? = null

    @JsonProperty("location_level3")
    var locationLevel3: String? = null

    @JsonProperty("date_reported")
    var dateReported: LocalDateTime? = null

    @JsonProperty("date_updated")
    var dateUpdated: LocalDateTime? = null

    @JsonProperty("date_reviewed")
    var dateReviewed: LocalDateTime? = null

    @JsonProperty("ontology_name")
    var ontologyName: String? = null

    @JsonProperty("common_name")
    var commonName: String? = null

    @JsonProperty("scientific_name")
    var scientificName: String? = null

    @JsonProperty("area_sampled")
    var areaSampled: BigDecimal? = null

    @JsonProperty("affected_area")
    var affectedArea: BigDecimal? = null

    @JsonProperty("area_unit")
    var areaUnit: BigDecimal? = null

    @JsonProperty("sample_source")
    var sampleSource: String? = null

    @JsonProperty("sample_desc")
    var sampleDesc: String? = null

    @JsonProperty("sample_size")
    var sampleSize: Int? = null

    @JsonProperty("affected_sample_size")
    var affectedSampleSize: Int? = null

    @JsonProperty("severity")
    var severity: Int? = null

    /**
     * whether detected or undetected
     */
    @JsonProperty("occurrence_status")
    var occurrenceStatus: String? = null

    @JsonProperty("comments")
    var comments: String? = null

    @JsonProperty("identification_method")
    var identificationMethod: String? = null

    @JsonProperty("data_collection_method")
    var dataCollectionMethod: String? = null

    @JsonProperty("visually_identified")
    var visuallyIdentified: Boolean? = null

    @JsonProperty("image_url")
    var imageUrl: String? = null

    @JsonProperty("identified_by")
    var identifiedBy: String? = null
}