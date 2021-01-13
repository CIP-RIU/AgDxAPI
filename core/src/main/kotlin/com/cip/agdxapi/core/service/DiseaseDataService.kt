package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.dto.DiseaseDataDto
import com.cip.agdxapi.core.dto.PestDataDto
import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.entities.CommonDataEntity
import com.cip.agdxapi.database.repos.DiseaseDataRepo
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class DiseaseDataService
constructor(val diseaseDataRepo: DiseaseDataRepo) {

    private val logger = LoggerFactory.getLogger(DiseaseDataService::class.java)

    private val modelMapper = MyModelMapper.init()

    fun getDiseaseData(pageable: Pageable): Page<DiseaseDataDto> {
        logger.info("Fetching disease data")
        val pestDataList = diseaseDataRepo.findAll(pageable)
        return pestDataList.map { dataEntity ->
            val pestDataDto = modelMapper.map(dataEntity, DiseaseDataDto::class.java)
            pestDataDto
        }
    }

    fun addDiseaseData(diseaseData: DiseaseDataDto): DiseaseDataDto {
        val entity = modelMapper.map(diseaseData, CommonDataEntity::class.java)

        logger.info("Adding disease data")
        return modelMapper.map(entity, DiseaseDataDto::class.java)
    }

}