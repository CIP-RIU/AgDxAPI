package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.CropDiseaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CropDiseaseRepo : JpaRepository<CropDiseaseEntity, Long>