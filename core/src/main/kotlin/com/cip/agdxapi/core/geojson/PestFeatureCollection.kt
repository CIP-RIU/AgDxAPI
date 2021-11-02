package com.cip.agdxapi.core.geojson

import com.cip.agdxapi.enums.EnumCollectionType
import com.fasterxml.jackson.annotation.JsonProperty

class PestFeatureCollection {
    @JsonProperty("type")
    var type: EnumCollectionType? = EnumCollectionType.FeatureCollection

    @JsonProperty("features")
    var features: List<PestFeature>? = null
}
