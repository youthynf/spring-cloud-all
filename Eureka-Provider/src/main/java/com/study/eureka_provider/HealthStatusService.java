package com.study.eureka_provider;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;

/**
 * 主动设置provider的健康状态，而不是依靠eureka来保证健康状态，因为其存在保护机制，不保证服务是否可用
 */
@Configuration
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;

    public void setStatus(Boolean status) {
        this.status  = status;
    }

    @Override
    public Health health() {
        // TODO Auto-generated method stub
        if(status)
            return new Health.Builder().up().build();
        return new Health.Builder().down().build();
    }

    public String getStatus() {
        // TODO Auto-generated method stub
        return this.status.toString();
    }
}
