package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.dto.PestDataDto
import com.cip.agdxapi.core.geojson.*
import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.entities.CropPestEntity
import com.cip.agdxapi.database.repos.CropPestRepo
import com.cip.agdxapi.enums.EnumCoordinateType
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.math.BigDecimal


@Service
class CropPestDataService
constructor(val cropPestRepo: CropPestRepo) {

    private val logger = LoggerFactory.getLogger(CropPestDataService::class.java)

    private val modelMapper = MyModelMapper.init()

    fun getPest(): CropPestEntity {
        return CropPestEntity()
    }

    fun getPests(pageable: Pageable): Page<PestDataDto> {
        val cropPestList = cropPestRepo.findAll(pageable)


        return cropPestList.map { dataEntity ->
            val cropPestDto = modelMapper.map(dataEntity, PestDataDto::class.java)
            cropPestDto
        }
    }

    fun getPestList(pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findAll(pageable)

        val featureCollection = PestFeatureCollection()
        val featureList = mutableListOf<PestFeature>()
        cropPestList.map { data ->
            val feature = PestFeature();
            val geometry = Geometry()
            geometry.altitude = data.alt
            geometry.locationLevel1 = data.locationLevel1
            geometry.locationLevel2 = data.locationLevel2
            geometry.locationLevel3 = data.locationLevel3
            geometry.type = EnumCoordinateType.Point

            val coordinates = mutableListOf<BigDecimal>()
            coordinates.add(data.lon!!)
            coordinates.add(data.lat!!)
            coordinates.add(data.alt!!)
            geometry.coordinates = coordinates

            feature.geometry = geometry

            val cropPestDto = modelMapper.map(data, PestDataDto::class.java)
            feature.properties = cropPestDto
            featureList.add(feature)
            featureList
        }
        featureCollection.features = featureList
        return featureCollection;
    }


    fun addPest(pestEntity: CropPestEntity): CropPestEntity {
        val cropPestEntity = modelMapper.map(pestEntity, CropPestEntity::class.java)

        val saved = cropPestRepo.save(cropPestEntity)

        logger.info("Adding pest data")
        return saved
    }


}
