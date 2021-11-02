package com.cip.agdxapi.core.geojson

import com.cip.agdxapi.core.dto.DiseaseDataDto
import com.cip.agdxapi.enums.EnumGeoType
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonProperty
import javax.annotation.Generated

@JsonPropertyOrder("geometry", "properties", "type")
class DiseaseFeature {
    @JsonProperty("geometry")
    var geometry: Geometry? = null

    @JsonProperty("properties")
    var properties: DiseaseDataDto? = null

    @JsonProperty("type")
    val type: EnumGeoType = EnumGeoType.Feature
}
