# 🧠 Lernfortschritt – SDA Backend Lab (privat)

Dieses Projekt dient der technischen Vertiefung im Bereich moderner Java-Backend-Entwicklung  
und untersucht die Integration von Modulen aus `sda-spring-boot-commons` sowie angrenzenden Technologien im Umfeld verteilter Systeme.

---

## 🚀 Ziel des Projekts

Dieses Projekt entstand aus dem Interesse, moderne Backend-Architekturen mit Spring Boot zu vertiefen und den Einsatz wiederverwendbarer Komponenten in verteilten Systemen besser zu verstehen.

Im Mittelpunkt steht der praktische Umgang mit der Bibliothek `sda-spring-boot-commons` (SSBC), um folgende Schwerpunkte umzusetzen:

- klare und erweiterbare Projektstruktur mit Spring Boot
- Entwicklung robuster REST-Schnittstellen auf Basis etablierter Standards
- zentrales Fehlerhandling und strukturiertes Logging (inkl. Trace-ID)
- automatisierte Konfiguration und Wiederverwendbarkeit durch SSBC
- Einstieg in weiterführende Themen wie Observability, Service Discovery und Clean Code

Das Projekt dient gleichzeitig als technische Übung zur Vertiefung von Best Practices für wartbare, testbare und skalierbare Backend-Services.

---

## 📁 Projektstruktur

```
sda-backend-lab/
├── eureka-demo/
│   ├── eureka-server/
│   ├── product-service/
│   │   ├── logging/                # Interceptor für MDC Correlation ID
│   │   ├── exception/              # Zentrales Error Handling
│   ├── order-service/
│   ├── docker-compose.yml
│   └── test/
│       └── result/
│           └── screenshoot.pdf    # Beweis der Funktionalität
├── README.md
└── todo.md                        # Vorbereitungsplan
```

---

## 📌 Funktionsüberblick

Dieses Projekt demonstriert:

- Microservice-Kommunikation mit Spring Boot
- Service Discovery mit **Eureka**
- SSBC-nahe Funktionalitäten:
  - 📌 `X-Correlation-Id` Interceptor (Header + MDC Logging)
  - 📌 Globales Exception Handling
- Dockerisierte Ausführung mit `docker-compose`
- Vorbereitung auf Architektur- und Codereviews bei SDA SE

---

## ✅ Modulübersicht nach Themen

### 🧱 Struktur & REST
- [x] Projektstruktur erstellt (Spring Boot + Maven)
- [ ] REST API mit `sda-commons-starter-web`
- [ ] OpenAPI + Swagger UI

### ❗ Fehlerbehandlung
- [x] Globales Fehlerhandling mit `@RestControllerAdvice`
- [ ] Eigene Exceptions + Response-Mapping

### 📊 Tracing & Metadata
- [x] MDC Logging mit `X-Correlation-Id`
- [ ] metadata-context Integration

### 📬 Kafka
- [ ] Kafka Producer & Consumer (Startermodul)
- [ ] Fehlerbehandlung + DLQ

### 🧪 Testing
- [ ] `web-testing` für Integrationstests
- [ ] Testcontainers (Postgres / Kafka)

### 🔐 Security
- [ ] JWT-Verarbeitung mit Spring Security
- [ ] Rollenbasierte Zugriffe

### ⚙️ DevOps
- [x] Dockerfile & Compose
- [ ] GitHub Actions (CI)
- [ ] Helm Chart

### 📈 Observability
- [ ] Prometheus / Grafana lokal
- [ ] Zipkin Tracing

### 🔄 API-Design
- [ ] API-Versionierung (`v1`, `v2`)
- [ ] OpenAPI Client Generator

---

## 🚀 Schnellstart

### Voraussetzungen

- Java 17
- Maven
- Docker & Docker Compose

### Starten der Services

```bash
cd eureka-demo
docker-compose up --build
```

Nach ca. 30–45 Sekunden:

- 🔗 Eureka Dashboard: [http://localhost:8761](http://localhost:8761)
- 📦 Produkt-Service: [http://localhost:8081/products/42](http://localhost:8081/products/42)
- 🧾 Order-Service: [http://localhost:8082/orders/42](http://localhost:8082/orders/42)

---

## 🧩 SSBC-ähnliche Features im `product-service`

| Feature              | Beschreibung                                                  |
|----------------------|---------------------------------------------------------------|
| ✅ Correlation-ID     | Jeder Request erhält `X-Correlation-Id` (Header + Logging)    |
| ✅ MDC Logging        | `SLF4J` nutzt `Mapped Diagnostic Context`                     |
| ✅ Global Exception   | Einheitliches `@RestControllerAdvice` Error-Handling          |

🧪 Testaufrufe:

```bash
curl -H "X-Correlation-Id: demo-123" http://localhost:8081/products/42
curl http://localhost:8081/products/fail
```

---

## 🖼️ Screenshot

📄 [Vollständiger Screenshot der Anwendung (PDF)](./eureka-demo/test/result/screenshoot.pdf)

---

## 🔗 Links

📁 GitHub: [github.com/thanhtuanh/sda-backend-lab](https://github.com/thanhtuanh/sda-backend-lab)  
📝 Letztes Update: 2025-05-31  
🔐 Status: privat – Lern- & Interviewvorbereitungsprojekt
