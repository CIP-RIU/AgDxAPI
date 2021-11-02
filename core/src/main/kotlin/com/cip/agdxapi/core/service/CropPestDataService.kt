package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.dto.PestDataDto
import com.cip.agdxapi.core.geojson.*
import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.entities.CropPestEntity
import com.cip.agdxapi.database.repos.CropPestRepo
import com.cip.agdxapi.enums.EnumCoordinateType
import com.cip.agdxapi.enums.EnumDetectionStatus
import com.cip.agdxapi.enums.EnumTreatmentStatus
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.util.MultiValueMap
import java.math.BigDecimal
import java.time.LocalDate


@Service
class CropPestDataService
constructor(val cropPestRepo: CropPestRepo) {

    private val logger = LoggerFactory.getLogger(CropPestDataService::class.java)

    private val modelMapper = MyModelMapper.init()

    fun addPest(pestEntity: CropPestEntity): CropPestEntity {
        val cropPestEntity = modelMapper.map(pestEntity, CropPestEntity::class.java)

        val saved = cropPestRepo.save(cropPestEntity)

        logger.info("Adding pest data")
        return saved
    }

    fun getPestByScientificName(scientificName: String): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByPestScientificName(scientificName)
        return buildGeoJson(cropPestList)
    }

    fun getPestByCommonName(commonName: String, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByPestCommonName(commonName)
        return buildGeoJson(cropPestList)
    }

    fun getPestList(pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findAll()
        return buildGeoJson(cropPestList)
    }

    fun getPestByObservedDate(fromDate: LocalDate, toDate: LocalDate, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByDateIdentifiedBetween(fromDate = fromDate, toDate = toDate)
        return buildGeoJson(cropPestList)
    }

    fun getPestByReportedDate(fromDate: LocalDate, toDate: LocalDate, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByDateIdentifiedBetween(fromDate = fromDate, toDate = toDate)
        return buildGeoJson(cropPestList)
    }


    fun getPestByRecordingDate(fromDate: LocalDate, toDate: LocalDate, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByDateIdentifiedBetween(fromDate = fromDate, toDate = toDate)
        return buildGeoJson(cropPestList)
    }

    fun getPestByCropName(cropName: String, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByPestCommonName(cropName)
        return buildGeoJson(cropPestList)
    }

    fun getPestByCultivar(cultivar: String, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByPestCommonName(cultivar)
        return buildGeoJson(cropPestList)
    }

    fun getPestByDetectionStatus(detectionStatus: EnumDetectionStatus, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByPestCommonName(detectionStatus.name)
        return buildGeoJson(cropPestList)
    }

    fun getPestByTreatmentStatus(treatmentStatus: EnumTreatmentStatus, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByPestCommonName(treatmentStatus.name)
        return buildGeoJson(cropPestList)
    }

    fun getPestByVector(vector: String, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByPestCommonName(vector)
        return buildGeoJson(cropPestList)
    }

    fun getPestByAdminLevel(adminLevel: String, pageable: Pageable): PestFeatureCollection {
        val cropPestList = cropPestRepo.findByPestCommonName(adminLevel)
        return buildGeoJson(cropPestList)
    }

    private fun buildGeoJson(cropPestList: List<CropPestEntity>): PestFeatureCollection {
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
        return featureCollection
    }


}
