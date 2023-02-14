package com.example.auth.security

import com.example.auth.security.jwt.JwtRequestFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
        private val jwtRequestFilter: JwtRequestFilter
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain =
            http
                    .cors()
                    .and()
                    .csrf().disable()
                    .httpBasic().disable()

                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()

                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/auth/signup").permitAll()
                    .antMatchers(HttpMethod.POST, "/auth/signin").permitAll()
                    .anyRequest().denyAll()
                    .and()
                    .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
                    .build()

    @Bean
    fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}