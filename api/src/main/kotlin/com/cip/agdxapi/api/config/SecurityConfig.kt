package com.cip.agdxapi.api.config

import com.cip.agdxapi.core.service.ApiUserPasswordService
import com.cip.agdxapi.core.service.ApiUserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.sql.DataSource


@Configuration
@EnableWebSecurity
class SecurityConfig(
    val datasource: DataSource,
    val apiUserService: ApiUserService,
    val apiUserPasswordService: ApiUserPasswordService
) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/unsecured", "/swagger-ui/**", "/agdxapi/**", "/registration") //excluded from authentication
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()

        http.headers().frameOptions().disable()
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password(passwordEncoder().encode("admin"))
            .authorities("ADMIN")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}