package com.cip.agdxapi.core.utils

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies

object MyModelMapper : ModelMapper() {

    fun init(): MyModelMapper {
        configuration.isSkipNullEnabled = false
        configuration.propertyCondition
        configuration.matchingStrategy = MatchingStrategies.STANDARD

        return this
    }

}
