import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

val generateChangelog by tasks.registering {
    val changeName: String? by project
    if (changeName.isNullOrEmpty()) {
        return@registering
    }
    val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
    val changeSetName = changeName?.replace(" ", "_")?.toLowerCase()
    val user = project.findProperty("author") ?: System.getProperty("user.name")
    val file = File("$projectDir/src/main/resources/db/changelog/${date}_$changeSetName.xml")
    val text = """<?xml version="1.0" encoding="utf-8"?>
<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.4.xsd">

    <changeSet id="$date" author="$user" labels="agdxapi">

    </changeSet>
</databaseChangeLog>
"""
    file.writeText(text)
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
    runtimeOnly("mysql:mysql-connector-java")

    implementation("org.liquibase:liquibase-core")
}
