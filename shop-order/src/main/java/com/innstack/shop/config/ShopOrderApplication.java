package com.innstack.shop.config;

import com.innstack.shop.OrderController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //非Eureka 使用@EnableDiscoveryClient

@EnableFeignClients(basePackages = {"com.innstack.shop.service"})

@EnableHystrix

@EnableHystrixDashboard
@EnableCircuitBreaker


@RestController
@ComponentScan(basePackageClasses = OrderController.class)//OrderController所在的包
public class ShopOrderApplication {

    @Value("${server.port}")
    String port;

    @Bean
    @LoadBalanced //RoundRobbin
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopOrderApplication.class, args);
    }


}