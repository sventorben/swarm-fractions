package de.sven_torben.wildfly.swarm.fractions.responsetime.runtime;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class ResponseTimeFilter implements HttpHandler {

  private HttpHandler next;

  public ResponseTimeFilter(HttpHandler next) {
    this.next = next;
  }

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {
    exchange.addExchangeCompleteListener(new StopWatch());
    if (next != null) {
      next.handleRequest(exchange);
    }
  }

}
