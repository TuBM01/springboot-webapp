package com.tubm.webapp.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTFilter jwtFilter;

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
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // cach hard code user hoat dong trong memory
    // @Bean
    // public UserDetailsService userDetailsService() {
    // UserDetails user1 = User.withDefaultPasswordEncoder()
    // .username("admin")
    // .password("admin")
    // .roles("ADMIN")
    // .build();

    // UserDetails user2 = User.withDefaultPasswordEncoder()
    // .username("user")
    // .password("user")
    // .roles("USER")
    // .build();
    // return new InMemoryUserDetailsManager(user1, user2);
    // }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        // provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // khong ma
        // hoa password nhap vao
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12)); // ma hoa password nhap vao
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
