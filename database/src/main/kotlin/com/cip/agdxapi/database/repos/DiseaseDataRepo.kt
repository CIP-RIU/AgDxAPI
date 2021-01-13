package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.CommonDataEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.transaction.Transactional

@Repository
interface DiseaseDataRepo : JpaRepository<CommonDataEntity, Long> {

    override fun findAll(pageable: Pageable): Page<CommonDataEntity>
}