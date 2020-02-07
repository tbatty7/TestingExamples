package com.battybuilds.testexamples.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimsHealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        return Health.down().withDetail("Reason", "Just feeling down").build();
    }
}
