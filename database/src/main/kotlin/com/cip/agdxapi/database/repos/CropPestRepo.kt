package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.CropPestEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CropPestRepo : JpaRepository<CropPestEntity, Long>