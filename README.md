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
├── eureka-demo/
│   ├── eureka-server/
│   ├── product-service/
│   ├── order-service/
│   ├── docker-compose.yml
│   └── test/
│       └── result/
│           └── screenshoot.pdf    # Beweis der Funktionalität
```

## 🚀 Schnellstart

### Voraussetzungen

- Docker & Docker Compose
- Java 17
- Maven

### Starten der Services

```bash
cd eureka-demo
docker-compose up --build
```

Warte 15–20 Sekunden. Danach:

- 🔗 [Eureka Dashboard](http://localhost:8761)
- 📦 `product-service`: [http://localhost:8081/products/123](http://localhost:8081/products/123)
- 🧾 `order-service`: [http://localhost:8082/orders/123](http://localhost:8082/orders/123)

## 🧭 Beispiel: Service Discovery in Aktion

Der `order-service` ruft intern über den **Service-Namen `product-service`** auf und erhält Produktdaten. Die Service-URL wird dynamisch über Eureka aufgelöst.

## 🖼️ Screenshot

📄 [Vollständiger Screenshot der Anwendung (PDF)](./eureka-demo/test/result/screenshoot.pdf)

## 🧩 Technologien

- Java 17
- Spring Boot 3.1
- Spring Cloud 2022.0.3
- Netflix Eureka
- Docker / Docker Compose
- REST / LoadBalanced `RestTemplate`

## 🔧 Weiterer Ausbau geplant

- Auth-Service mit JWT
- API-Gateway mit Spring Cloud Gateway
- Monitoring mit Prometheus & Grafana
- Erweiterung für OpenAI-Integration

---

📁 GitHub: [github.com/thanhtuanh/sda-backend-lab](https://github.com/thanhtuanh/sda-backend-lab)  
🔗 Demo und neue Module folgen!
