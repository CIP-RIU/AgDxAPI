package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.geojson.*
import com.cip.agdxapi.core.utils.MyModelMapper
import com.cip.agdxapi.database.entities.CropDiseaseEntity
import com.cip.agdxapi.database.entities.CropEntity
import com.cip.agdxapi.database.repos.CropDiseaseRepo
import com.cip.agdxapi.database.repos.CropRepo
import com.cip.agdxapi.enums.EnumCoordinateType
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate

@Service
class CropDiseaseDataService
constructor(val cropDiseaseRepo: CropDiseaseRepo, val cropRepo: CropRepo) {

    private val logger = LoggerFactory.getLogger(CropDiseaseDataService::class.java)

    private val modelMapper = MyModelMapper.init()

    fun getSingleCropDisease(diseaseId: Long): CropDiseaseEntity? {
        logger.info("Fetching disease data for disease id $diseaseId")
        val diseaseList = cropDiseaseRepo.findByIdOrNull(diseaseId)
        val crop = diseaseList?.cropId?.let { cropRepo.findByIdOrNull(it) }

        diseaseList?.cropEntity = crop
        return diseaseList
    }

    fun addCropDisease(cropDiseaseData: CropDiseaseEntity): CropDiseaseEntity {
        val entity = modelMapper.map(cropDiseaseData, CropDiseaseEntity::class.java)

        logger.info("Adding crop disease data")
        return cropDiseaseRepo.save(entity)
    }

    fun getDiseaseData(pageable: Pageable): DiseaseFeatureCollection {
        logger.info("Fetching disease data")
        val diseaseList = cropDiseaseRepo.findAll()

        return buildGeoJson(diseaseList)
    }

    fun getCropDisease(cropId: Long, pageable: Pageable): DiseaseFeatureCollection {
        logger.info("Fetching disease data for crop id $cropId")
        val diseaseList = cropDiseaseRepo.findAllByCropId(cropId)
        val crop = cropRepo.findById(cropId)
        return buildGeoJson(diseaseList, crop.get())
    }

    fun getCropDiseasesByObservedDate(cropId: Long, fromDate: LocalDate, toDate: LocalDate, pageable: Pageable): DiseaseFeatureCollection {
        val cropDiseaseList = cropDiseaseRepo.findAllByCropIdAndDateObservedBetween(cropId = cropId, fromDate = fromDate, toDate = toDate)
        return buildGeoJson(cropDiseaseList)
    }

    fun getCropDiseasesByRecordedDate(cropId: Long, fromDate: LocalDate, toDate: LocalDate, pageable: Pageable): DiseaseFeatureCollection {
        val cropDiseaseList = cropDiseaseRepo.findAllByCropIdAndDateRecordedBetween(cropId = cropId, fromDate = fromDate, toDate = toDate)
        return buildGeoJson(cropDiseaseList)
    }

    fun getCropDiseasesByCountryCode(cropId: Long, countryCode: String, pageable: Pageable): DiseaseFeatureCollection {
        val cropDiseaseList = cropDiseaseRepo.findAllByCropIdAndCountryCode(cropId = cropId, countryCode = countryCode)
        return buildGeoJson(cropDiseaseList)
    }

    fun getCropDiseasesByCountryCode(cropId: Long, countryCode: List<String>, pageable: Pageable): DiseaseFeatureCollection {
        val cropDiseaseList = cropDiseaseRepo.findAllByCropIdAndCountryCodeIn(cropId = cropId, countryCode = countryCode)
        return buildGeoJson(cropDiseaseList)
    }

    fun getCropDiseasesByCountryCode(countryCodes: List<String>, pageable: Pageable): DiseaseFeatureCollection {
        val cropDiseaseList = cropDiseaseRepo.findAllByCountryCodeIn(countryCodes = countryCodes)
        return buildGeoJson(cropDiseaseList)
    }

    fun getCropDiseasesByProjectName(cropId: Long, projectName: String, pageable: Pageable): DiseaseFeatureCollection {
        val cropDiseaseList = cropDiseaseRepo.findAllByProjectName(projectName = projectName)
        return buildGeoJson(cropDiseaseList)
    }

    fun getCropDiseasesByProjectName(projectName: String, pageable: Pageable): DiseaseFeatureCollection {
        val cropDiseaseList = cropDiseaseRepo.findAllByProjectName(projectName = projectName)
        return buildGeoJson(cropDiseaseList)
    }


    private fun buildGeoJson(diseaseList: List<CropDiseaseEntity>, crop: CropEntity? = null): DiseaseFeatureCollection {
        val featureCollection = DiseaseFeatureCollection()
        val featureList = mutableListOf<DiseaseFeature>()

        diseaseList.map { data ->
            val feature = DiseaseFeature();
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
            if (crop != null) {
//                cropDiseaseDto.commonName = crop.commonName
//                cropDiseaseDto.scientificName = crop.scientificName
                data.cropEntity = crop
            }
            feature.properties = data
            featureList.add(feature)
            featureList
        }
        featureCollection.features = featureList
        return featureCollection
    }
}
