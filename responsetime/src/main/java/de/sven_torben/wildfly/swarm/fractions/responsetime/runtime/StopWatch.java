package de.sven_torben.wildfly.swarm.fractions.responsetime.runtime;

import io.undertow.server.ExchangeCompletionListener;
import io.undertow.server.HttpServerExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class StopWatch implements ExchangeCompletionListener {

  private static final Logger LOG = LoggerFactory.getLogger(ResponseTimeFilter.class);

  private final long start = System.currentTimeMillis();

  @Override
  public void exchangeEvent(HttpServerExchange exchange, NextListener nextListener) {
    long stop = System.currentTimeMillis();
    LOG.trace("[" + getIdentifier(exchange) + "] Request took " 
            + (stop - start) + " ms");
    if (nextListener != null) {
      nextListener.proceed();
    }
  }
  
  private String getIdentifier(HttpServerExchange exchange) {
    return exchange.getRequestMethod().toString() + " " + exchange.getRequestPath();
  }
}
