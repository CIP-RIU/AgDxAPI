package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumPathogenCategory {
    @JsonProperty("Virus")
    Virus,

    @JsonProperty("Bacteria")
    Bacteria,

    @JsonProperty("Fungi")
    Fungi,

    @JsonProperty("Protozoa")
    Protozoa,

    @JsonProperty("Plants")
    Plants
}
