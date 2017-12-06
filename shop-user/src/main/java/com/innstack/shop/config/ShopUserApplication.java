package com.innstack.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableEurekaClient

@SpringBootApplication
@RestController
public class ShopUserApplication {

    @Value("${server.port}")
    String port;

    public static void main(String[] args) {
        SpringApplication.run(ShopUserApplication.class, args);
    }

    @RequestMapping("/user")
    public String user() {
        return "username:a,i am from port:" + port;
    }


    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}