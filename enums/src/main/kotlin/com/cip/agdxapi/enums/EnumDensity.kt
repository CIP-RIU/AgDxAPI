package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumDensity {
    @JsonProperty("Low")
    Low,

    @JsonProperty("Medium")
    Medium,

    @JsonProperty("High")
    High,

    @JsonProperty("Common")
    Common,

    @JsonProperty("Rare")
    Rare
}