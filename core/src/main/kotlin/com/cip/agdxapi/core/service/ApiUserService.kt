package com.cip.agdxapi.core.service

import com.cip.agdxapi.database.entities.ApiUsersEntity
import com.cip.agdxapi.database.repos.ApiUsersRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ApiUserService
constructor(private val apiUsersRepo: ApiUsersRepo) {

    fun loadUserByUsername(username: String): ApiUsersEntity {

        return apiUsersRepo.findByUsername(username) ?: throw Exception()
    }
}