package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.repos.CommonDataRepo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PestDataService
constructor(val commonDataRepo: CommonDataRepo) {

    private val logger = LoggerFactory.getLogger(PestDataService::class.java)

    private val modelMapper = MyModelMapper.init()


}