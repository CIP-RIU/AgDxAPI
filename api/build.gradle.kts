plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}


openApi {
    apiDocsUrl.set("http://localhost:9200/agdx-api")
    outputDir.set(file("$projectDir/api-docs"))
    outputFileName.set("swagger.json")
    waitTimeInSeconds.set(70)
    forkProperties.set("-Dserver.port=9200")
}

dependencies {
    val swaggerVersion = "3.0.0"


    implementation(project(":core"))
    implementation(project(":database"))
    implementation(project(":enums"))

    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")


    implementation("org.openapitools:openapi-generator-gradle-plugin:5.0.0")


    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
//    testImplementation("org.springframework.security:spring-security-test")
}