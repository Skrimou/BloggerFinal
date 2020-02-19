package com.esliceu.springbootintento.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowCredentials(true).
                allowedOrigins("http://localhost:63343").
                allowedMethods("PUT","POST","GET","DELETE","OPTIONS");
    }
}
