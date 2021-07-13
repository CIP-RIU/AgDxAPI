package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.entities.CropPestEntity
import com.cip.agdxapi.database.repos.CropPestRepo
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class CropPestDataService
constructor(val cropPestRepo: CropPestRepo) {

    private val logger = LoggerFactory.getLogger(CropPestDataService::class.java)

    private val modelMapper = MyModelMapper.init()

    fun getPest(): CropPestEntity {
        return CropPestEntity()
    }

    fun getPests(pageable: Pageable): Page<CropPestEntity> {
        logger.info("Fetching crop pest data")
        return cropPestRepo.findAll(pageable)
//        return cropPestList.map { dataEntity ->
//            val cropPEstDto = modelMapper.map(dataEntity, PestDataDto::class.java)
//            cropPEstDto
//        }
    }


    fun addPest(pestEntity: CropPestEntity): CropPestEntity {
        val cropPestEntity = modelMapper.map(pestEntity, CropPestEntity::class.java)

        val saved = cropPestRepo.save(cropPestEntity)

        logger.info("Adding pest data")
        return saved
    }


}
