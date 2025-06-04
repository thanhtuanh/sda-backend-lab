package com.example.orderservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private final List<Order> orders = new ArrayList<>();
    private int nextId = 1;

    @GetMapping
    public List<Order> getAllOrders() {
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return orders.stream()
            .filter(o -> o.getId() == id)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Bestellung mit ID " + id + " nicht gefunden."));
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setId(nextId++);
        orders.add(order);

        // Optional: Produktdetails prüfen/holen
        String productJson = restTemplate.getForObject("http://product-service/products/" + order.getProductId(), String.class);
        System.out.println("Neue Bestellung für Produkt: " + productJson + ", Anzahl: " + order.getQuantity() + ", Order-ID: " + order.getId());

        return order;
    }
}