package com.spring.security.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
        try {
            http.authorizeHttpRequests(config ->
                    config.requestMatchers(HttpMethod.GET,"/v1/test/admin").hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.GET,"/v1/test/user").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET,"/v1/test/public/*").permitAll());
            http.httpBasic(Customizer.withDefaults());
            http.csrf(csrf -> csrf.disable());
            return http.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
