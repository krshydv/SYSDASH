package com.monitoring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

/**
 * CORS configuration allowing the frontend (served from a different origin during development)
 * to call the Spring Boot REST API.
 *
 * In production, restrict allowedOrigins to your actual frontend domain.
 */
@Configuration
public class CorsConfig {

    @Value("${sysdash.cors.allowed-origins:http://localhost:3000,http://localhost:8080}")
    private String allowedOriginsRaw;

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Parse comma-separated origins from application.properties
        List<String> origins = List.of(allowedOriginsRaw.split(","));
        config.setAllowedOrigins(origins);

        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**",      config);
        source.registerCorsConfiguration("/actuator/**", config);
        return new CorsFilter(source);
    }
}
