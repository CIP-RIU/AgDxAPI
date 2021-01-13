import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
}


dependencies {
    val springDoc  = "1.5.2"

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":database"))


    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    api("org.springframework.boot:spring-boot-starter-validation")
//    implementation("org.springframework.boot:spring-boot-starter-security")
//    api("org.springframework.boot:spring-boot-starter-data-rest")
    api("com.fasterxml.jackson.module:jackson-module-kotlin")

    api("com.github.rozidan:modelmapper-spring-boot-starter:2.3.1")

    api("org.springdoc:springdoc-openapi-ui:${springDoc}")
    api("org.springdoc:springdoc-openapi-kotlin:${springDoc}")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.springframework.security:spring-security-test")
}