package com.example.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication // Markiert dies als Hauptklasse für Spring Boot (Startpunkt)
@EnableDiscoveryClient // Aktiviert die Registrierung bei Eureka
public class ProductServiceApplication {

    public static void main(String[] args) {
        // Startet die Spring Boot Anwendung
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
