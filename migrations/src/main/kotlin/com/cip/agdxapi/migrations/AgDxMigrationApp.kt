package com.cip.agdxapi.migrations

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AgDxMigrationApp

fun main(args: Array<String>) {
    runApplication<AgDxMigrationApp>(*args)
}