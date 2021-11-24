package com.cip.agdxapi.core.request

import java.math.BigDecimal

data class CoordinateRequest(
    var lat: BigDecimal,
    var lon: BigDecimal
)
