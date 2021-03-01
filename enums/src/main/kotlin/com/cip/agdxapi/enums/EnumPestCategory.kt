package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumPestCategory {
    @JsonProperty("Virus")
    Virus,

    @JsonProperty("Bacteria")
    Bacteria,

    @JsonProperty("Nematode")
    Nematode,

    @JsonProperty("Plant")
    Plant,

    @JsonProperty("Insect")
    Insect
}