package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.CropDiseaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
interface CropDiseaseRepo : PagingAndSortingRepository<CropDiseaseEntity, Long> {
    fun findByCountryCode(@Param("countryCode") countryCode: String): List<CropDiseaseEntity>

}