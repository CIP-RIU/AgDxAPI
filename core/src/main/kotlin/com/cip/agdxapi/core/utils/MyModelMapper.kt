package com.cip.agdxapi.core.utils

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies

object MyModelMapper : ModelMapper() {

    fun init(): MyModelMapper {
        configuration.isSkipNullEnabled = true
        configuration.propertyCondition
        configuration.matchingStrategy = MatchingStrategies.STRICT

        return this
    }

}