package com.example.productservice.config;

import com.example.productservice.logging.CorrelationIdInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration // Markiert diese Klasse als Konfigurationsklasse
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired // Spring injiziert automatisch die Abhängigkeit
    private CorrelationIdInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Den Interceptor bei allen Webanfragen einbinden
        registry.addInterceptor(interceptor);
    }
}
