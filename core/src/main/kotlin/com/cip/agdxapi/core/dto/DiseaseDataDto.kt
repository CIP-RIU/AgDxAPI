package com.cip.agdxapi.core.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

class DiseaseDataDto : CommonDataDto() {

    @Schema(description = "Common ontology name", example = "Banana", required = true)
    override var ontologyName: String? = null

    @Schema(description = "Common disease name", example = "BXW", required = true)
    override var commonName: String? = null

    @Schema(description = "Scientific pest name", example = "Xanthomonas wilt of banana", required = true)
    override var scientificName: String? = null

    @Schema(description = "Where the sample was obtained", example = "Field", required = true)
    override var sampleSource: String? = null

    @Schema(description = "Description of sample type", example = "Banana stems", required = true)
    override var sampleDesc: String? = null

    @Schema(description = "Sample size", example = "50", required = true)
    override var sampleSize: Int? = null

    @Schema(description = "Sample size", example = "48", required = true)
    override var affectedSampleSize: Int? = null

    @Schema(description = "Severity of occurrence", example = "4", required = true)
    override var severity: Int? = null

    /**
     * whether detected or undetected
     */
    @Schema(description = "Status of occurrence", example = "Detected", required = true)
    override var occurrenceStatus: String? = null


    @Schema(
        description = "Comments",
        example = "Symptoms of BXW are progressive yellowing, withering and necrosis of leaves;",
        required = false
    )
    override var comments: String? = null

    @Schema(description = "Identification method", example = "Visual", required = true)
    override var identificationMethod: String? = null

    @Schema(description = "Data collection method", example = "Field visit", required = true)
    override var dataCollectionMethod: String? = null
}