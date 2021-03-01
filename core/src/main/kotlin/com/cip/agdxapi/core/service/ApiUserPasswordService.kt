package com.cip.agdxapi.core.service

import com.cip.agdxapi.core.components.UserDetailsMapper
import com.cip.agdxapi.database.entities.ApiUsersEntity
import com.cip.agdxapi.database.repos.ApiUsersRepo
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsPasswordService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class ApiUserPasswordService
constructor(
    private val userRepository: ApiUsersRepo,
    private val userDetailsMapper: UserDetailsMapper
) : UserDetailsPasswordService {

    override fun updatePassword(user: UserDetails, newPassword: String?): UserDetails? {
        val userCredentials = userRepository.findByUsername(user.username)
        if (userCredentials != null) {
            userCredentials.password = newPassword
            return userDetailsMapper.toUserDetails(userCredentials)
        }
        return null
    }
}