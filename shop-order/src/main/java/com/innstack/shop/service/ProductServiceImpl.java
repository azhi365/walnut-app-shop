package com.innstack.shop.service;

import org.springframework.stereotype.Component;

@Component("productService")
public class ProductServiceImpl implements ProductService {

    @Override
    public String getProduct() {
        return "get product error by feign";
    }
}
