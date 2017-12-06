package com.innstack.shop.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@FeignClient(value = "shop-user",configuration = RibbonConfiguration.class)
@FeignClient(value = "shop-user")
public interface UserService {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String getUser();
}