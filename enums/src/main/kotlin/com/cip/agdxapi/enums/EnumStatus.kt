package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumStatus {
    @JsonProperty("Undetected")
    UNDETECTED,

    @JsonProperty("Detected")
    DETECTED
}