package com.innstack.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ShopProductApplication {

    @Value("${server.port}")
    String port;

    @Value("${version}}")
    String version;

    public static void main(String[] args) {
        SpringApplication.run(ShopProductApplication.class, args);
    }

    @RequestMapping("/product")
    public String product() {
        return "product:1,i am from port:" + port;
    }

    @RequestMapping("/version")
    public String version() {
        return version;
    }


    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}