package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumCoordinateType {
    @JsonProperty("Point")
    Point,

    @JsonProperty("LineString")
    LineString,

    @JsonProperty("Polygon")
    Polygon,

    @JsonProperty("MultiPoint")
    MultiPoint,

    @JsonProperty("MultiLineString")
    MultiLineString,

    @JsonProperty("MultiPolygon")
    MultiPolygon
}
