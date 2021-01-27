package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.CommonDataEntity
import com.cip.agdxapi.database.entities.CropPestEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CropPestRepo : JpaRepository<CropPestEntity, Long> {
    override fun findAll(pageable: Pageable): Page<CropPestEntity>
}