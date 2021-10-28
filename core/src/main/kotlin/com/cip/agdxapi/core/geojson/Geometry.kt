package com.cip.agdxapi.core.geojson

import com.cip.agdxapi.enums.EnumCoordinateType
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import javax.annotation.Generated

@JsonPropertyOrder("altitude", "coordinates", "high_accuracy_gps", "iso3","location_level1", "location_level2", "location_level3", "location_level4", "type")
class Geometry {
    @JsonProperty("altitude")
    var altitude: BigDecimal? = null

    @JsonProperty("coordinates")
    var coordinates: MutableList<BigDecimal>? = null

    @JsonProperty("high_accuracy_gps")
    var highAccuracyGps: Long = 0

    @JsonProperty("iso3")
    var iso3: String? = null

    @JsonProperty("location_level1")
    var locationLevel1: String? = null

    @JsonProperty("location_level2")
    var locationLevel2: String? = null

    @JsonProperty("location_level3")
    var locationLevel3: String? = null

    @JsonProperty("location_level4")
    var locationLevel4: String? = null

    @JsonProperty("type")
    var type: EnumCoordinateType = EnumCoordinateType.Point
}
