package com.cip.agdxapi.database.entities

import com.cip.agdxapi.database.entities.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.JoinColumn

import javax.persistence.JoinTable

import javax.persistence.ElementCollection




@Entity
@Table(name = "api_users")
class ApiUsersEntity {
    @Id
    @Column(name = "username", nullable = false)
    var username: String? = null

    @Column(name = "email", nullable = false)
    var email: String? = null

    @Column(name = "password", nullable = false)
    var password: String? = null

    @Column(name = "enabled")
    var enabled: Boolean? = null

    @ElementCollection
    @JoinTable(name = "authorities", joinColumns = [JoinColumn(name = "username")])
    @Column(name = "authority")
    var roles: Set<String>? = null
}