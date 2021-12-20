package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.entities.PestEntity
import com.cip.agdxapi.database.repos.PestRepo
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class PestDataService
constructor(val cropPestRepo: PestRepo) {

    private val logger = LoggerFactory.getLogger(PestDataService::class.java)

    private val modelMapper = MyModelMapper.init()

    fun getPest(): PestEntity {
        return PestEntity()
    }

    fun getPests(pageable: Pageable): Page<PestEntity> {
        logger.info("Fetching crop pest data")
        val pests = cropPestRepo.findAll(pageable)

        return pests;
    }


    fun addPest(pestEntity: PestEntity): PestEntity {
        val cropPestEntity = modelMapper.map(pestEntity, PestEntity::class.java)

        val saved = cropPestRepo.save(cropPestEntity)

        logger.info("Adding pest data")
        return saved
    }


}
