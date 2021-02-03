package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumStatus {
    @JsonProperty("Undetected")
    Undetected,

    @JsonProperty("Detected")
    Detected
}