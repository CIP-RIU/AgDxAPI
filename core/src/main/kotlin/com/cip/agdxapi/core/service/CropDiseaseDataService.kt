package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.entities.CropDiseaseEntity
import com.cip.agdxapi.database.repos.CropDiseaseRepo
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CropDiseaseDataService
constructor(val cropDiseaseRepo: CropDiseaseRepo) {

    private val logger = LoggerFactory.getLogger(CropDiseaseDataService::class.java)

    private val modelMapper = MyModelMapper.init()

    fun getDiseaseData(pageable: Pageable): Page<CropDiseaseEntity> {
        logger.info("Fetching disease data")
        return cropDiseaseRepo.findAll(pageable)
    }

    fun addCropDisease(cropDiseaseData: CropDiseaseEntity): CropDiseaseEntity {
        val entity = modelMapper.map(cropDiseaseData, CropDiseaseEntity::class.java)

        logger.info("Adding crop disease data")
        return cropDiseaseRepo.save(entity)
    }

}