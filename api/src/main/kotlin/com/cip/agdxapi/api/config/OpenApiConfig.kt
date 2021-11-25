package com.cip.agdxapi.api.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
//@SecurityScheme(name = "api", scheme = "basic", type = SecuritySchemeType.HTTP, `in` = SecuritySchemeIn.HEADER)
class OpenApiConfig {
    @Bean
    fun api(
        @Value("\${agdx.version}") appVersion: String,
        @Value("\${agdx.name}") appName: String,
        @Value("\${agdx.contact.name}") name: String,
        @Value("\${agdx.contact.email}") email: String,
        @Value("\${agdx.contact.url}") url: String,
    ): OpenAPI {

        val contact  = Contact()
        contact.name = name
        contact.email = email
        contact.url = url
        return OpenAPI()
            .info(
                Info().title(appName)
                    .description("$appName facilitates sharing of crop pest and disease data between platforms and/or by providing links between complementary ICT tools where appropriate.")
                    .version(appVersion)
                    .contact(contact)
                    .license(License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
            )
            .components(
                Components().addSecuritySchemes(
                    "jwt",
                    SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                        .`in`(SecurityScheme.In.HEADER).name("Authorization")
                ).addSecuritySchemes(
                    "api",
                    SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")
                        .`in`(SecurityScheme.In.HEADER).name("Authorization")
                )
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("$appName Wiki Documentation")
                    .url("#")
            )
    }
}
