package com.tubm.webapp.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Customizer<CsrfConfigurer<HttpSecurity>> csrfCustomizer = new
        // Customizer<CsrfConfigurer<HttpSecurity>>() {
        // @Override
        // public void customize(CsrfConfigurer<HttpSecurity> csrf) {
        // csrf.disable();
        // }
        // };
        // http.csrf(csrfCustomizer);
        // http.csrf(csrf -> csrf.disable()); // disable csrf

        // http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()); // all
        // requests must be authenticated
        // http.formLogin(Customizer.withDefaults()); // enable form login
        // http.httpBasic(Customizer.withDefaults()); // enable http basic -> return
        // json not html file
        // http.sessionManagement(session ->
        // session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // return http.build();

        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
