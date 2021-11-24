package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.CropDiseaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface CropDiseaseRepo : PagingAndSortingRepository<CropDiseaseEntity, Long> {

    override fun findAll(): List<CropDiseaseEntity>

    fun findAllByCountryCode(countryCode: String): List<CropDiseaseEntity>

    fun findAllByCropId(cropId: Long): List<CropDiseaseEntity>

    fun findAllByDateIdentifiedBetween(fromDate: LocalDate, toDate: LocalDate): List<CropDiseaseEntity>

    fun findAllByCropIdAndDateObservedBetween(cropId: Long, fromDate: LocalDate, toDate: LocalDate): List<CropDiseaseEntity>

    fun findAllByCropIdAndDateRecordedBetween(cropId: Long, fromDate: LocalDate, toDate: LocalDate): List<CropDiseaseEntity>

    fun findAllByCropIdAndCountryCode(cropId: Long, countryCode: String): List<CropDiseaseEntity>

    fun findAllByProjectName(projectName: String): List<CropDiseaseEntity>
}
