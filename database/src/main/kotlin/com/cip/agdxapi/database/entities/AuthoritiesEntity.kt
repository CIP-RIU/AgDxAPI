package com.cip.agdxapi.database.entities

import com.cip.agdxapi.database.entities.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "authorities")
class AuthoritiesEntity : BaseEntity() {
    @Column(name = "username", nullable = false)
    var username: String? = null

    @Column(name = "authority", nullable = false)
    var authority: String? = null
}