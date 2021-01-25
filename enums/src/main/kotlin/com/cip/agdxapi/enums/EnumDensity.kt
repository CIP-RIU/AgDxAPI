package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumDensity {
    @JsonProperty("Undetected")
    UNDETECTED,

    @JsonProperty("Detected")
    DETECTED
}