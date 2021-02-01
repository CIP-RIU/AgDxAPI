package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumNameType {
    @JsonProperty("common")
    COMMON,

    @JsonProperty("scientific")
    SCIENTIFIC
}