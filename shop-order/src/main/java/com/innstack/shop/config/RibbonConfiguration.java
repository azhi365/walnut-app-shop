package com.innstack.shop.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Autowired
    private IClientConfig ribbonClientConfig;

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        // return new AvailabilityFilteringRule();
        return new RandomRule();//
        // return new BestAvailableRule();
        // return new RoundRobinRule();//轮询
        // return new WeightedResponseTimeRule();
        // return new RetryRule();
        // return new ZoneAvoidanceRule();
    }
}
