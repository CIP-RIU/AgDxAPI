package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.utils.MyModelMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PestDataService
constructor() {

    private val logger = LoggerFactory.getLogger(PestDataService::class.java)

    private val modelMapper = MyModelMapper.init()


}