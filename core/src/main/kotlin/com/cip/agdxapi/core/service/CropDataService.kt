package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.entities.CropEntity
import com.cip.agdxapi.database.entities.PestEntity
import com.cip.agdxapi.database.repos.CropRepo
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class CropDataService
constructor(val cropPestRepo: CropRepo) {

    private val logger = LoggerFactory.getLogger(CropDataService::class.java)

    private val modelMapper = MyModelMapper.init()

    fun getCrop(): CropEntity {
        return CropEntity()
    }

    fun getCrops(pageable: Pageable): Page<CropEntity> {
        logger.info("Fetching crop data")
        return cropPestRepo.findAll(pageable)
    }


    fun addCrop(pestEntity: CropEntity): CropEntity {
        val cropPestEntity = modelMapper.map(pestEntity, CropEntity::class.java)

        val saved = cropPestRepo.save(cropPestEntity)

        logger.info("Adding crop data")
        return saved
    }


}