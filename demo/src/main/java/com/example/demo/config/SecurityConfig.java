package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //Config 1
/*    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
return httpSecurity
        .authorizeHttpRequests()
            .requestMatchers("/v1/index2").permitAll()
            .anyRequest().authenticated()
        .and()
        .formLogin().permitAll()
        .and()
        .httpBasic()
        .and()
        .build();
    }*/

    //Config 2
    /**
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    @Bean
    @SuppressWarnings("removal")
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/v1/index2").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin()
                .successHandler(succesHandler()) // URL indicada
                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // ALWAYS - IF-REQUIRED - NEVER - STATELESS
                .invalidSessionUrl("/login")
                .maximumSessions(1)
                .expiredUrl("/login")
                .sessionRegistry(sessionRegistry())
                .and()
                .sessionFixation()
                .migrateSession() //migrateSession - newSession - none
                .and()
                .build();

    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    public AuthenticationSuccessHandler succesHandler() {
        return ((request, response, authentication) -> {
            response.sendRedirect("/v1/session");
        });
    }
}

