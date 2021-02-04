package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumTreatmentStatus {
    @JsonProperty("Undetected")
    Undetected,

    @JsonProperty("Detected")
    Detected
}