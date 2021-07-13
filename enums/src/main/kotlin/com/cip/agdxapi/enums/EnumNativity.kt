package com.cip.agdxapi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class EnumNativity {
    @JsonProperty("Introduced")
    INTRODUCED,

    @JsonProperty("Native")
    NATIVE
}
