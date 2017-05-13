package de.sven_torben.wildfly.swarm.fractions.responsetime.runtime;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.wildfly.swarm.config.undertow.configuration.CustomFilter;
import org.wildfly.swarm.config.undertow.server.host.FilterRef;
import org.wildfly.swarm.spi.api.Customizer;
import org.wildfly.swarm.spi.runtime.annotations.Post;
import org.wildfly.swarm.undertow.UndertowFraction;

@Post
@ApplicationScoped
public class ResponseTimeCustomizer implements Customizer {

  private static final String SERVER_NAME = "default-server";
  private static final String HOST_NAME = "default-host";
  private static final String FILTER_NAME = "responsetime";

  @Inject
  private Instance<UndertowFraction> undertowFractionInstance;

  @Override
  public void customize() {

    if (undertowFractionInstance.isUnsatisfied()) {
      throw new RuntimeException("The responsetime fraction needs the undertow fraction!");
    }

    UndertowFraction undertowFraction = undertowFractionInstance.get();

    FilterRef filterRef = new FilterRef(FILTER_NAME);

    if (undertowFraction.subresources().filterConfiguration() == null) {
      undertowFraction.filterConfiguration();
    }

    undertowFraction.subresources()
        .filterConfiguration()
        .customFilter(new CustomFilter(FILTER_NAME)
            .module("de.sven_torben.wildfly.swarm.fractions.responsetime:runtime")
            .className(ResponseTimeFilter.class.getName())
      );

    undertowFraction
        .subresources()
        .server(SERVER_NAME)
        .subresources()
        .host(HOST_NAME)
        .filterRef(filterRef);
  }

}
