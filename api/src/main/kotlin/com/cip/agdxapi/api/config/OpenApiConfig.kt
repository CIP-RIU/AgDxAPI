package com.cip.agdxapi.api.config

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@SecurityScheme(name = "api", scheme = "basic", type = SecuritySchemeType.HTTP, `in` = SecuritySchemeIn.HEADER)
class OpenApiConfig() {
    @Bean
    fun api(
        @Value("\${cip.version}") appVersion: String,
        @Value("\${cip.name}") appName: String
    ): OpenAPI {
        return OpenAPI()
            .info(
                Info().title(appName)
                    .description("$appName facilitates sharing of crop pest and disease data between platforms and/or by providing links between complementary ICT tools where appropriate.")
                    .version(appVersion)
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("$appName Wiki Documentation")
                    .url("#")
            )
    }
}