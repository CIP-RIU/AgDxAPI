package com.cip.agdxapi.core.geojson

import com.cip.agdxapi.enums.EnumCoordinateType
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import javax.annotation.Generated

@JsonPropertyOrder(
    "altitude",
    "coordinates",
    "high_accuracy_gps",
    "iso3",
    "location_level1",
    "location_level2",
    "location_level3",
    "location_level4",
    "type"
)
class Geometry {
    @JsonProperty("altitude")
    var altitude: BigDecimal? = null

    @Schema(description = "GPS coordinates lon,lat,alt", type = "List", example = "[36.821945, -1.292066, 0]", required = true)
    @JsonProperty("coordinates")
    var coordinates: MutableList<BigDecimal>? = null

    @Schema(description = "Accuracy of GPS location in meters", example = "1.0")
    @JsonProperty("high_accuracy_gps")
    var highAccuracyGps: Long = 0

    @JsonProperty("iso3")
    var iso3: String? = null

    @Schema(description = "Administrative level one; Province,district,region", example = "Western Province", required = true)
    @JsonProperty("location_level1")
    var locationLevel1: String? = null

    @Schema(description = "Administrative level two; municipality,district", example = "Kakamega", required = true)
    @JsonProperty("location_level2")
    var locationLevel2: String? = null

    @Schema(description = "Administrative level three; city,town or farm name", example = "Shianda", required = true)
    @JsonProperty("location_level3")
    var locationLevel3: String? = null

    @Schema(description = "Administrative level four", example = "Lvl 4", required = false)
    @JsonProperty("location_level4")
    var locationLevel4: String? = null

    @JsonProperty("type")
    var type: EnumCoordinateType = EnumCoordinateType.Point
}
