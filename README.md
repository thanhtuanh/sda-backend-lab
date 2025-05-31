# 📦 Microservice-Demo mit Spring Boot & Eureka – im Stil von SDA SE

Ein vollständiges Beispielprojekt zur Demonstration von Microservice-Kommunikation mit **Spring Boot**, **Eureka Server (Netflix OSS)** und **Docker Compose**.

Dieses Projekt wurde im Rahmen meiner beruflichen Weiterbildung als Java-Entwickler erstellt und eignet sich ideal zur Demonstration meiner Kenntnisse in verteilten Systemen und serviceorientierter Architektur (SOA).

---

## 🔧 Technologien

- Java 17
- Spring Boot 3.1
- Spring Cloud (Eureka Client/Server)
- REST APIs (Spring Web)
- Docker & Docker Compose
- Maven (Multi-Stage Build)
- Service Discovery (Eureka)
- Inter-Service Communication via `RestTemplate`

---

## 📦 Projektstruktur

```text
eureka-demo/
├── eureka-server/       → Registrierungszentrale (Eureka Server)
├── product-service/     → Service A: Produktinformationen
├── order-service/       → Service B: ruft Produktservice auf
└── test/result/screenshoot.pdf → Ergebnisnachweis mit Screenshot
```

---

## ▶️ Schnellstart mit Docker

Voraussetzung: [Docker](https://www.docker.com/) ist installiert.

```bash
git clone https://github.com/thanhtuanh/eureka-demo.git
cd eureka-demo
docker-compose up --build
```

---

## 🌐 Endpunkte testen

- **Eureka Dashboard:**  
  [http://localhost:8761](http://localhost:8761)

- **Produkt-Service:**  
  [http://localhost:8081/products/42](http://localhost:8081/products/42)  
  → `Produkt #42`

- **Bestell-Service (via Eureka):**  
  [http://localhost:8082/orders/42](http://localhost:8082/orders/42)  
  → `Bestellung erstellt für: Produkt #42`

---

## 📄 Ergebnis-Screenshot

Hier sehen Sie den erfolgreichen Testlauf im `.http`-Format:

📎 [Ergebnis anzeigen (screenshoot.pdf)](test/result/screenshoot.pdf)

---

## ✅ Lernziele & Highlights

- Verständnis für verteilte Microservice-Architektur
- Aufbau eines Service-Registry-Systems mit Eureka
- Dynamische Kommunikation zwischen Services (Service Discovery)
- Docker-basiertes Deployment von Spring Boot Projekten

---

## 📂 Referenz

Dieses Projekt ist Teil meines GitHub-Portfolios zur beruflichen Weiterentwicklung:  
🔗 [https://github.com/thanhtuanh/bewerbung](https://github.com/thanhtuanh/bewerbung)

---

## 👤 Autor

Duc Thanh Nguyen  
Senior Java Fullstack Entwickler  
📫 [n.thanh@gmx.de](mailto:n.thanh@gmx.de)
