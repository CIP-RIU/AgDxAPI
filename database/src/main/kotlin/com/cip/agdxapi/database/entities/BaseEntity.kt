package com.cip.agdxapi.database.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
open class BaseEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

//    @CreationTimestamp
//    @Column(name = "created_at", updatable = false, nullable = false)
//    var createdAt: LocalDateTime? = null
//
//    @UpdateTimestamp
//    @Column(name = "updated_at", insertable = false)
//    var updatedAt: LocalDateTime? = null
}
