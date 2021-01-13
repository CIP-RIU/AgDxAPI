package com.cip.agdxapi.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import kotlin.Throws
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.lang.Exception
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import javax.sql.DataSource


@Configuration
@EnableWebSecurity
class SecurityConfig(val datasource: DataSource) : WebSecurityConfigurerAdapter() {

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
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.jdbcAuthentication()
            .dataSource(datasource)
            .withUser("admin")
            .password(passwordEncoder().encode("password"))
            .authorities("ADMIN")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}