package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.ApiUsersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ApiUsersRepo : JpaRepository<ApiUsersEntity, String> {
    fun findByUsername(username: String): ApiUsersEntity?
}