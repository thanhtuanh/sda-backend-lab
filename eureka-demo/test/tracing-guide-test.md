Um Tracing (verteiltes Tracing, z.B. OpenTelemetry mit Tempo oder Jaeger) anzuzeigen oder zu testen, folge diesen Schritten:

---

## 1. Stelle sicher, dass dein Tracing-Backend läuft

- **Tempo** läuft z. B. auf `http://localhost:3200` (nach deiner Konfiguration).
- **Jaeger**: Falls du Jaeger nutzt, meist auf `http://localhost:16686`.

---

## 2. Tracing in deinen Anwendungen aktivieren

- In Spring Boot:  
  In deiner `application.properties`:
  ```
  management.tracing.enabled=true
  management.otlp.tracing.endpoint=http://tempo:4320
  ```
  (Passe Host/Port ggf. an.)

---

## 3. Einen Trace erzeugen

- Sende eine HTTP-Anfrage an einen deiner Services, zum Beispiel mit einer `.http`-Datei oder `curl`:

  ```http
  GET http://localhost:8081/products
  X-Correlation-Id: my-test-trace-123
  ```

  Oder mit `curl`:
  ```bash
  curl -H "X-Correlation-Id: my-test-trace-123" http://localhost:8081/products
  ```

- Wiederhole dies ggf. mit weiteren Endpunkten und/oder mit dem Order-Service.

---

## 4. Traces im Tempo-UI (oder Jaeger) suchen

- Öffne deinen Browser und gehe zu `http://localhost:3200` (Tempo UI)  
  oder zu Jaeger: `http://localhost:16686`
- Suche nach deiner Correlation-ID (`my-test-trace-123`) oder nach Service-Name (z. B. `product-service`).

**In Tempo:**  
- Öffne die “Search” oder “Explore”-Ansicht.
- Gib die Correlation-ID ein – oder filtere nach Zeit, Service etc.
- Du solltest die Requests als Spans/Traces sehen, ggf. mit Parent/Child-Beziehungen, wenn mehrere Services beteiligt waren!

---

## 5. Alternative: Tempo mit Grafana

- Wenn du Tempo mit Grafana verbunden hast, öffne Grafana (`http://localhost:3000`)
- Gehe zu “Explore” > “Tempo”
- Suche nach deiner Correlation-ID, Trace ID oder Service-Name.

---

## 6. Tipps zum Tracing-Test

- Verwende immer denselben Wert für `X-Correlation-Id` bei einer Testkette (z.B. Produkt POST → Order POST mit Produkt-ID).
- Die Logs deiner Services sollten die Correlation-ID auch ausgeben, wenn Logging korrekt konfiguriert ist.

---

### Beispiel `.http`-Testfile:

```http
GET http://localhost:8081/products
X-Correlation-Id: trace-demo-1

###

POST http://localhost:8082/orders
Content-Type: application/json
X-Correlation-Id: trace-demo-1

{
  "productId": 1,
  "quantity": 2
}
```

---

**Zusammengefasst:**  
- **Backend läuft?** (Tempo/Jaeger/Grafana)
- **Export richtig konfiguriert?** (Endpoint, Port)
- **Anfrage mit Correlation-ID senden**
- **Im UI nach ID oder Service suchen**

---

Wenn du keine Traces siehst, prüfe:
- Logs vom Service: Wird Trace exportiert?
- Tempo-Logs auf Fehler (Port/Empfang)
- Export-Endpunkt korrekt gesetzt?
- Firewall/Netzwerk?
