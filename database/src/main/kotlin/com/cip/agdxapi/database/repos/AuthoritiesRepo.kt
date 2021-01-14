package com.cip.agdxapi.database.repos

import com.cip.agdxapi.database.entities.AuthoritiesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface AuthoritiesRepo : JpaRepository<AuthoritiesEntity, Long>