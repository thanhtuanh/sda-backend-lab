package com.example.orderservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public String createOrder(@PathVariable String id) {
        String product = restTemplate.getForObject("http://product-service/products/" + id, String.class);
        return "Bestellung erstellt für: " + product;
    }
}