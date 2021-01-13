package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.dto.PestDataDto
import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.entities.CommonDataEntity
import com.cip.agdxapi.database.repos.PestDataRepo
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PestDataService
constructor(val pestDataRepo: PestDataRepo) {

    private val logger = LoggerFactory.getLogger(PestDataService::class.java)

    private val modelMapper = MyModelMapper.init()


    fun getPestData(pageable: Pageable): Page<PestDataDto> {
        logger.info("Fetching pest data")
        val pestDataList = pestDataRepo.findAll(pageable)
        return pestDataList.map { dataEntity ->
            val pestDataDto = modelMapper.map(dataEntity, PestDataDto::class.java)
            pestDataDto
        }
    }

    fun addPestData(pestData: PestDataDto): PestDataDto {
        val entity = modelMapper.map(pestData, CommonDataEntity::class.java)

        val saved = pestDataRepo.save(entity)

        logger.info("Adding pest data")
        return modelMapper.map(saved, PestDataDto::class.java)
    }


}