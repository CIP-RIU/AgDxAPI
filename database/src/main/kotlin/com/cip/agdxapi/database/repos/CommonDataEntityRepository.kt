package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.CommonDataEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommonDataEntityRepository : JpaRepository<CommonDataEntity, Long>