# 🧠 SDA Backend Lab – Microservice Architektur mit Observability

Dieses Projekt dient der technischen Vertiefung im Bereich moderner Java-Backend-Entwicklung mit Fokus auf:

* Microservice-Architektur mit Spring Boot
* Wiederverwendbare Komponenten aus `sda-spring-boot-commons`
* Service Discovery mit Eureka
* Fehlerhandling, strukturierte Logs & Tracing
* Observability mit OpenTelemetry, Prometheus & Grafana Tempo

---

## 🚀 Projektziele

* Aufbau eines stabilen, wartbaren Microservice-Systems
* Technische Vertiefung in moderne Open-Source-Werkzeuge rund um Observability
* Erweiterung praktischer Erfahrung mit Tracing, Metrics und Logs in Cloud-nahen Systemen

---

## 🔧 Technologien

| Bereich        | Tools / Frameworks                   |
| -------------- | ------------------------------------ |
| Framework      | Spring Boot 3.3, Java 17             |
| Microservices  | Eureka Discovery, RestTemplate       |
| Logging        | SLF4J, MDC, Logback + Correlation-ID |
| Tracing        | OpenTelemetry + OTLP (Trace/Span)    |
| Monitoring     | Micrometer, Prometheus               |
| Visualisierung | Grafana, Tempo (Traces), Dashboards  |
| Deployment     | Docker Compose                       |

---

## 📁 Projektstruktur

```
sda-backend-lab/
├── eureka-demo/
│   ├── eureka-server/           # Service Registry
│   ├── product-service/         # REST + Observability integriert
│   ├── order-service/           # ruft product-service auf
│   ├── test/                    # curl-Testskripte
│   ├── docker-compose.yml       # All-in-One Setup
│   └── prometheus.yml           # Monitoring-Konfiguration
├── grafana/
│   └── provisioning/
│       ├── datasources/
│       │   └── datasource.yml
│       ├── dashboards/
│       │   ├── dashboard.yml
│       │   ├── product-observability.json
│       │   └── order-observability.json
├── README.md                    # Kombinierte Dokumentation
├── README_Observability.md     # Zusatzdoku (nur Observability)
└── todo.md                      # Themenplan & Technologietraining
```

---

## 🔍 Core-Funktionalität

### 🔹 Microservices

* `product-service`: REST API, MDC Logging, Exception Handling
* `order-service`: REST Call via Eureka-Discovery auf `product-service`

### 🔹 Fehler-Handling

* Zentrale Fehlerbehandlung mit `@RestControllerAdvice`
* Automatische Rückgabe strukturierter JSON-Fehlermeldungen

### 🔹 Logging & Correlation ID

* Jeder Request erhält `X-Correlation-Id`
* Automatische Übergabe im HTTP-Header & Log-Kontext (MDC)

---

## 📈 Observability mit OpenTelemetry

### 🔧 Setup

* Tracing mit `opentelemetry-spring-boot-starter`
* Export zu Tempo Collector (`OTLP gRPC`)
* Prometheus liest Spring Metriken von Services
* Grafana zeigt alle Datenquellen zentral an

### 📊 Dashboards

| Dashboard                        | Inhalt                         |
| -------------------------------- | ------------------------------ |
| 📊 Product Service Observability | Requests, Dauer, Traces        |
| 📦 Order Service Observability   | Traces + Performance über Zeit |

### 🔗 Zugriff

* Grafana UI: [http://localhost:3000](http://localhost:3000)
* Benutzer: `admin` / Passwort: `admin`

---

## 🚀 Schnellstart

### Voraussetzungen:

* Java 17, Maven
* Docker & Docker Compose

### Starten:

```bash
cd eureka-demo
docker-compose up --build
```

### Testen:

```bash
curl http://localhost:8081/products/42
curl http://localhost:8082/orders/42
```

---

## 🔍 Motivation als Senior Java Entwickler

Dieses Projekt wurde als persönliche technische Vertiefung initiiert, um moderne Entwicklungen im Bereich der **Observability, Microservice-Kommunikation und Infrastrukturautomatisierung** praxisnah zu erlernen und gezielt auszuprobieren. Ziel ist es, neue Technologien nicht nur theoretisch zu verstehen, sondern in einem echten Anwendungsfall zu erproben und sauber zu dokumentieren.

---

Letztes Update: 2025-06-03
