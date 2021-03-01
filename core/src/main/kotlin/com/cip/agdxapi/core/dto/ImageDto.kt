package com.cip.agdxapi.core.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

class ImageDto {
    @Schema(description = "Image http links", example = "https://placehold.co/600x400/000000/FFFFFF/png", required = true)
    @JsonProperty("imageUrl")
    var imageUrl: String? = null
}