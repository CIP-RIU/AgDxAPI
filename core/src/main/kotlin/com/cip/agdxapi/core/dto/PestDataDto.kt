package com.cip.agdxapi.core.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class PestDataDto {

    @Schema(description = "GPS lat", example = "36.821945", required = true)
    @JsonProperty("lat")
    var lat: BigDecimal? = null

    @Schema(description = "GPS lon", example = "-1.292066", required = true)
    @JsonProperty("lon")
    var lon: BigDecimal? = null

    @Schema(description = "Identification Altitude above sea level", example = "1200", required = true)
    @JsonProperty("alt")
    var alt: BigDecimal? = null

    @Schema(description = "Accuracy of GPS location in meters", example = "1.0", required = true)
    @JsonProperty("accuracy")
    var accuracy: BigDecimal? = null

    @Schema(description = "Country code of the identification: ISO2", example = "KE", required = false)
    @JsonProperty("country_code")
    var countryCode: String? = null

    @Schema(description = "Country of the identification", example = "Kenya", required = true)
    @JsonProperty("country_name")
    var countryName: String? = null


    @Schema(description = "Administrative level one; Province,district,region", example = "Western Province", required = true)
    @JsonProperty("location_level1")
    var locationLevel1: String? = null

    @Schema(description = "Administrative level two; municipality,district", example = "Kakamega", required = true)
    @JsonProperty("location_level2")
    var locationLevel2: String? = null

    @Schema(description = "Administrative level three; city,town or farm name", example = "Shianda", required = true)
    @JsonProperty("location_level3")
    var locationLevel3: String? = null

    @Schema(description = "Date when occurrence was first reported", example = "2021-01-13", required = true)
    @JsonProperty("date_reported")
    var dateReported: LocalDate? = null

    @Schema(description = "Date when occurrence was updated", example = "2021-01-13", required = true)
    @JsonProperty("date_updated")
    var dateUpdated: LocalDate? = null

    @Schema(description = "Date when occurrence was reviewed", example = "2021-01-13", required = true)
    @JsonProperty("date_reviewed")
    var dateReviewed: LocalDate? = null

    @Schema(description = "Common ontology name", example = "Banana", required = true)
    @JsonProperty("ontology_name")
    var ontologyName: String? = null

    @Schema(description = "Common pest name", example = "Banana weevil borer", required = true)
    @JsonProperty("common_name")
    var commonName: String? = null

    @Schema(description = "Scientific pest name", example = "Cosmopolites sordidus", required = true)
    @JsonProperty("scientific_name")
    var scientificName: String? = null

    @Schema(description = "Size of land sampled", example = "2", required = true)
    @JsonProperty("area_sampled")
    var areaSampled: BigDecimal? = null

    @Schema(description = "Size of land affected", example = "1.5", required = true)
    @JsonProperty("affected_area")
    var affectedArea: BigDecimal? = null

    @Schema(description = "Land measurement unit", example = "ha", required = true)
    @JsonProperty("area_unit")
    var areaUnit: String? = null

    @Schema(description = "Where the sample was obtained", example = "Field", required = true)
    @JsonProperty("sample_source")
    var sampleSource: String? = null

    @Schema(description = "Description of sample type", example = "Banana stems", required = true)
    @JsonProperty("sample_desc")
    var sampleDesc: String? = null

    @Schema(description = "Sample size", example = "200", required = true)
    @JsonProperty("sample_size")
    var sampleSize: Int? = null

    @Schema(description = "Sample size", example = "200", required = true)
    @JsonProperty("affected_sample_size")
    var affectedSampleSize: Int? = null

    @Schema(description = "Severity of occurrence", example = "4", required = true)
    @JsonProperty("severity")
    var severity: Int? = null

    /**
     * whether detected or undetected
     */
    @Schema(description = "Status of occurrence", example = "Detected", required = true)
    @JsonProperty("occurrence_status")
    var occurrenceStatus: String? = null


    @Schema(
        description = "Comments",
        example = "Adult weevils are about 10-12mm long, hard shelled and have the pronounced snout typical of weevils",
        required = false
    )
    @JsonProperty("comments")
    var comments: String? = null

    @Schema(description = "Identification method", example = "Visual", required = true)
    @JsonProperty("identification_method")
    var identificationMethod: String? = null

    @Schema(description = "Data collection method", example = "Field visit", required = true)
    @JsonProperty("data_collection_method")
    var dataCollectionMethod: String? = null

    @Schema(description = "Visually identified", example = "true", required = true)
    @JsonProperty("visually_identified")
    var visuallyIdentified: Boolean? = null

    @JsonProperty("image_url")
    var imageUrl: String? = null

    @Schema(description = "Identified by", example = "John Doe", required = true)
    @JsonProperty("identified_by")
    var identifiedBy: String? = null
}