package com.innstack.shop;

import com.innstack.shop.service.ProductService;
import com.innstack.shop.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
//@RibbonClient(name = "shop-user", configuration = RibbonConfiguration.class)
@RefreshScope
public class OrderController {

    @Autowired
    UserService userService;
    @Resource
    ProductService productService;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon")
    public String ribbon() {
        StringBuilder rs = new StringBuilder("rs:");
        rs.append("-------------\n");
        for (int i = 0; i < 10; i++) {
            rs.append(restTemplate.getForObject("http://SHOP-USER/user", String.class)).append("\n");
        }
        rs.append(restTemplate.getForObject("http://SHOP-PRODUCT/product", String.class)).append("\n");
        rs.append("-------------\n");
        return rs.toString();
    }

    @RequestMapping(value = "/ribbonHystrix")
    @HystrixCommand(fallbackMethod = "ribbonError")
    public String ribbonHystrix() {
        return restTemplate.getForObject("http://SHOP-PRODUCT/product", String.class);
    }


    public String ribbonError() {
        return "sorry,error!";
    }

    @RequestMapping(value = "/feign")
    public String feign() {
        return userService.getUser();
    }

    @RequestMapping(value = "/feignHystrix")
    public String feignHystrix() {
        return productService.getProduct();
    }


    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/config")
    public String config(){
        return foo;
    }
}
