package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumTreatmentStatus {
    @JsonProperty("Treated")
    Treated,

    @JsonProperty("Untreated")
    Untreated
}
