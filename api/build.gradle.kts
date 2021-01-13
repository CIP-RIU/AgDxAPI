plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    val swaggerVersion  = "3.0.0"
    val springDoc  = "1.5.2"

    implementation(project(":core"))
    implementation(project(":database"))

    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("org.springframework.boot:spring-boot-starter-web")

//    implementation("io.springfox:springfox-boot-starter:3.0.0")
//    implementation("io.springfox:springfox-swagger-ui:3.0.0")


//    implementation("io.springfox:springfox-swagger2:${swaggerVersion}")
//    implementation("io.springfox:springfox-swagger-ui:${swaggerVersion}")
//    implementation("io.springfox:springfox-bean-validators:${swaggerVersion}")

//    implementation("org.springdoc:springdoc-openapi-core:${springDoc}")
    implementation("org.springdoc:springdoc-openapi-ui:${springDoc}")
    implementation("org.springdoc:springdoc-openapi-kotlin:${springDoc}")
//    implementation("org.springdoc:springdoc-openapi-data-rest:1.5.2")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.springframework.security:spring-security-test")
}