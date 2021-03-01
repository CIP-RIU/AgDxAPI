package com.cip.agdxapi.core.components

import com.cip.agdxapi.database.entities.ApiUsersEntity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component class UserDetailsMapper {
    fun toUserDetails(userCredentials: ApiUsersEntity): UserDetails {
        return User.withUsername(userCredentials.username)
            .password(userCredentials.password)
            .roles(userCredentials.roles.toString())
            .build()
    }
}