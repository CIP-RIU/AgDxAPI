package com.cip.agdxapi.core.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class PestDataDto : CommonDataDto() {


    @Schema(description = "Common ontology name", example = "Banana", required = true)
    override var ontologyName: String? = null

    @Schema(description = "Common pest name", example = "Banana weevil borer", required = true)
    override var commonName: String? = null

    @Schema(description = "Scientific pest name", example = "Cosmopolites sordidus", required = true)
    override var scientificName: String? = null

    @Schema(description = "Where the sample was obtained", example = "Field", required = true)
    override var sampleSource: String? = null

    @Schema(description = "Description of sample type", example = "Banana stems", required = true)
    override var sampleDesc: String? = null

    @Schema(description = "Sample size", example = "200", required = true)
    override var sampleSize: Int? = null

    @Schema(description = "Sample size", example = "200", required = true)
    override var affectedSampleSize: Int? = null

    @Schema(description = "Severity of occurrence", example = "4", required = true)
    override var severity: Int? = null

    @Schema(description = "Status of occurrence", example = "Detected", required = true)
    override var occurrenceStatus: String? = null


    @Schema(
        description = "Comments",
        example = "Adult weevils are about 10-12mm long, hard shelled and have the pronounced snout typical of weevils",
        required = false
    )
    override var comments: String? = null

    @Schema(description = "Identification method", example = "Visual", required = true)
    override var identificationMethod: String? = null

    @Schema(description = "Data collection method", example = "Field visit", required = true)
    override var dataCollectionMethod: String? = null
}
