package ism.atelier.atelier.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/")
                .allowedOrigins(
                        "http://localhost:4200",               // Angular en local
                        "https://frontback3.vercel.app",      // Angular en production
                        "http://localhost",                    // Flutter en dev (simulateur)
                        "http://127.0.0.1"                     // Flutter en dev (alternative)
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}