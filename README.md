# SDA Backend Lab 🧪

Ein persönliches Backend-Labor mit Fokus auf moderne Spring Boot Microservices-Architektur, Service Discovery und Vorbereitung auf die Position bei **SDA SE**.

## 🔍 Überblick

Dieses Projekt dient als technische Demonstration für:
- Microservice-Kommunikation mit Spring Boot
- Service Discovery via **Eureka**
- Clean Architecture mit separaten Modulen
- Dockerisierung und lokale Ausführung mit `docker-compose`
- Vorbereitung auf Architekturaufgaben im Bewerbungsgespräch

## 📁 Struktur

```
sda-backend-lab/
├── eureka-demo/              # Beispielprojekt: Eureka + 2 Services
│   ├── eureka-server/
│   ├── product-service/
│   └── order-service/
├── test/
│   └── result/
│       └── screenshot.pdf    # Beweis der Funktionalität
└── docker-compose.yml        # Startet alle Services gemeinsam
```

## 🚀 Schnellstart

### Voraussetzungen

- Docker & Docker Compose
- Java 17
- Maven

### Starten der Services

```bash
docker-compose up --build
```

Warte 15–20 Sekunden. Danach:

- 🔗 [Eureka Dashboard](http://localhost:8761)
- 📦 `product-service`: [http://localhost:8081/products/123](http://localhost:8081/products/123)
- 🧾 `order-service`: [http://localhost:8082/orders/123](http://localhost:8082/orders/123)

## 🧭 Beispiel: Service Discovery in Aktion

Der `order-service` ruft intern über den **Service-Namen `product-service`** auf und erhält Produktdaten. Die Service-URL wird dynamisch über Eureka aufgelöst.

## 🖼️ Screenshot

![Screenshot](./eureka-demo/test/result/screenshoot.pdf)

## 🧩 Technologien

- Java 17
- Spring Boot 3.1
- Spring Cloud 2022.0.3
- Netflix Eureka
- Docker / Docker Compose
- REST / LoadBalanced `RestTemplate`

## 🧪 Weitere Pläne

- Auth-Service mit JWT
- API-Gateway mit Spring Cloud Gateway
- OpenAI-basierte Microservices
- Monitoring mit Prometheus & Grafana

---

📁 GitHub: [github.com/thanhtuanh/sda-backend-lab](https://github.com/thanhtuanh/sda-backend-lab)  
🔗 Demo und Erweiterungen folgen!
