#!/bin/bash

## product-service direkt testen
## Erwartete Ausgabe: "Produkt #42"
curl http://localhost:8081/products/42
echo

## Fehlerfall testen
## Erwartete Ausgabe (HTTP 500):
## {"error":"RuntimeException","message":"Absichtlicher Fehler zum Testen"}
curl http://localhost:8081/products/fail
echo

## order-service ruft intern product-service über Eureka auf
## Erwartete Ausgabe: "Bestellung erstellt für: Produkt #42"
curl http://localhost:8082/orders/42
echo
