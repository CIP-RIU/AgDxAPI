package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.CropEntity
import com.cip.agdxapi.database.entities.CropPestEntity
import com.cip.agdxapi.database.entities.PestEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CropRepo : PagingAndSortingRepository<CropEntity, Long> {
    override fun findAll(pageable: Pageable): Page<CropEntity>
}