package de.sven_torben.wildfly.swarm.fractions.correlationid.runtime;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HeaderValues;

public class CorrelationIdFilter implements HttpHandler {

  private static final String[] HEADER_NAMES = { "X-Correlation-ID", "X-Request-ID" };

  private HttpHandler next;

  public CorrelationIdFilter(HttpHandler next) {
    this.next = next;
  }

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {
    if (next != null) {
      next.handleRequest(exchange);
    }
    for (String header : HEADER_NAMES) {
      if (exchange.getRequestHeaders().contains(header)) {
        HeaderValues headerValues = exchange.getRequestHeaders().get(header);
        exchange.getResponseHeaders().addAll(headerValues.getHeaderName(), headerValues);
      }
    }
  }

}
