package com.cip.agdxapi.core.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.validation.constraints.Size

@JsonInclude(JsonInclude.Include.NON_NULL)
open class CommonDataDto {

    @Schema(description = "GPS lat", example = "36.821945", required = true)
    var lat: BigDecimal? = null

    @Schema(description = "GPS lon", example = "-1.292066", required = true)
    var lon: BigDecimal? = null

    @Schema(description = "Identification Altitude above sea level", example = "1200", required = true)
    var alt: BigDecimal? = null

    @Schema(description = "Accuracy of GPS location in meters", example = "1.0", required = true)
    var accuracy: BigDecimal? = null

    @Schema(description = "Country code of the identification: ISO2", example = "KE", required = false)
    @Size(min = 2, max = 2)
    var countryCode: String? = null

    @Schema(description = "Country of the identification", example = "Kenya", required = true)
    var countryName: String? = null

    @Schema(description = "Administrative level one; Province,district,region", example = "Western Province", required = true)
    var locationLevel1: String? = null

    @Schema(description = "Administrative level two; municipality,district", example = "Kakamega", required = true)
    var locationLevel2: String? = null

    @Schema(description = "Administrative level three; city,town or farm name", example = "Shianda", required = true)
    @JsonProperty("location_level3")
    var locationLevel3: String? = null

    @Schema(description = "Date when occurrence was first reported", example = "2021-01-13", required = true)
    var dateReported: LocalDate? = null

    @Schema(description = "Date when occurrence was updated", example = "2021-01-13", required = true)
    var dateUpdated: LocalDate? = null

    @Schema(description = "Date when occurrence was reviewed", example = "2021-01-13", required = true)
    var dateReviewed: LocalDate? = null

    @Schema(description = "Common ontology name for the crop e.g Banana, Cassava, Rice", example = "Banana", required = true)
    open var ontologyName: String? = null

    @Schema(description = "Common name", example = "BXW", required = true)
    open var commonName: String? = null

    @Schema(description = "Scientific name", example = "Xanthomonas wilt of banana", required = true)
    open var scientificName: String? = null

    @Schema(description = "Size of land sampled", example = "2", required = true)
    var areaSampled: BigDecimal? = null

    @Schema(description = "Size of land affected", example = "1.5", required = true)
    var affectedArea: BigDecimal? = null

    @Schema(description = "Land measurement unit", example = "ha", required = true)
    var areaUnit: String? = null

    @Schema(description = "Where the sample was obtained", example = "Field", required = true)
    open var sampleSource: String? = null

    @Schema(description = "Description of sample type", example = "Banana stems", required = true)
    open var sampleDesc: String? = null

    @Schema(description = "Sample size", example = "50", required = true)
    open var sampleSize: Int? = null

    @Schema(description = "Sample size", example = "48", required = true)
    open var affectedSampleSize: Int? = null

    @Schema(description = "Severity of occurrence", example = "4", required = true)
    open var severity: Int? = null

    @Schema(description = "Status of occurrence", example = "Detected", required = true)
    open var occurrenceStatus: String? = null


    @Schema(
        description = "Comments",
        example = "Symptoms of BXW are progressive yellowing, withering and necrosis of leaves;",
        required = false
    )
    open var comments: String? = null

    @Schema(description = "Identification method", example = "Visual", required = true)
    open var identificationMethod: String? = null

    @Schema(description = "Data collection method", example = "Field visit", required = true)
    open var dataCollectionMethod: String? = null

    @Schema(description = "Visually identified", example = "true", required = true)
    var visuallyIdentified: Boolean? = null

    var images: ArrayList<ImageDto>? = null

    @Schema(description = "Identified by", example = "John Doe", required = true)
    var identifiedBy: String? = null
}