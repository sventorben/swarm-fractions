package de.sven_torben.wildfly.swarm.fractions.responsetime;

import org.wildfly.swarm.spi.api.Fraction;
import org.wildfly.swarm.spi.api.annotations.DeploymentModule;
import org.wildfly.swarm.spi.api.annotations.DeploymentModules;

@DeploymentModules({
    @DeploymentModule(name = "de.sven_torben.wildfly.swarm.fractions.responsetime")
})
public class ResponseTimeFraction implements Fraction<ResponseTimeFraction> {
}
