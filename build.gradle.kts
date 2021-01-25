buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
        jcenter()
    }
}

plugins {
    val kotlinVersion = "1.4.21"
    val springVersion = "2.4.1"

    id("org.springframework.boot") version springVersion apply false
    id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false
    id("name.remal.check-updates") version "1.0.211" apply false


    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    kotlin("plugin.jpa") version kotlinVersion apply false
}
allprojects {
    group = "com.cip"
    version = "1.0.0"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "14"
        targetCompatibility = "14"
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "14"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

subprojects {
    repositories {
        mavenCentral()
        mavenLocal()
        maven {
            url = uri("https://jitpack.io")
        }
    }
    apply {
        plugin("io.spring.dependency-management")
        plugin("name.remal.check-updates")
    }
}