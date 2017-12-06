package com.innstack.shop.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "shop-product",fallback = ProductServiceImpl.class)
public interface ProductService {
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    String getProduct();
}