package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.CropPestEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface CropPestRepo : PagingAndSortingRepository<CropPestEntity, Long> {

    override fun findById(id: Long): Optional<CropPestEntity>

    override fun findAll(pageable: Pageable): Page<CropPestEntity>
    override fun findAll(): List<CropPestEntity>

    fun findByPestScientificName(scientificName: String): List<CropPestEntity>

    fun findByPestCommonName(commonName: String): List<CropPestEntity>

    fun findByDateIdentifiedBetween(fromDate: LocalDate, toDate: LocalDate): List<CropPestEntity>
}
