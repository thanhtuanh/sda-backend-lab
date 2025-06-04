package com.example.productservice.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component // Spring-Komponente (wird automatisch erkannt)
public class CorrelationIdInterceptor implements HandlerInterceptor {

    private static final String CORRELATION_ID = "X-Correlation-Id"; // HTTP-Header-Name

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Versuche die Correlation-ID aus dem Header zu lesen
        String correlationId = request.getHeader(CORRELATION_ID);

        if (correlationId == null || correlationId.isBlank()) {
            // Falls keine vorhanden ist → neue UUID erzeugen
            correlationId = UUID.randomUUID().toString();
        }

        // In den Logging-Kontext (MDC) setzen → wichtig für Log-Ausgaben
        MDC.put(CORRELATION_ID, correlationId);

        // Die Correlation-ID auch im Response-Header zurückgeben
        response.setHeader(CORRELATION_ID, correlationId);

        return true; // Weiter mit der Verarbeitung
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) {
        // Nach der Anfrage wird die Correlation-ID aus dem Logging-Kontext entfernt
        MDC.remove(CORRELATION_ID);
    }
}
