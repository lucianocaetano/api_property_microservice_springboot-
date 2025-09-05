package com.microservice.server1.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Value("${service.security.secure-key-username}")
    private String USERNAME;

    @Value("${service.security.secure-key-password}")
    private String PASSWORD;

    @Bean
    public SecurityFilterChain securityFilterChain(
        HttpSecurity http
    ) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(
            AuthenticationManagerBuilder.class
        );

        System.out.println("USERNAME: " + USERNAME);
        System.out.println("PASSWORD: " + PASSWORD);
        
        auth.inMemoryAuthentication()
            .withUser(USERNAME)
            .password(new BCryptPasswordEncoder().encode(PASSWORD))
            .authorities(
                 AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_ADMIN")
             )
            .and()
            .passwordEncoder(new BCryptPasswordEncoder());

        return http
            .cors(CorsConfigurer::disable)
            .csrf(CsrfConfigurer::disable)
            .authorizeHttpRequests(request -> {
                request.anyRequest().hasAuthority("ROLE_ADMIN");
            })
            .httpBasic(Customizer.withDefaults())
            .build();
    }
}
