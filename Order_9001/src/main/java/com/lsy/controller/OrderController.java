package com.lsy.controller;

import com.lsy.fegin.StockFeignService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

//    @Resource
//    private RestTemplate restTemplate;

    @Value("${order.total}")
    private Integer orderTotal;

    @Resource
    private StockFeignService stockFeignService;
    @GetMapping("/add")
    public String add() {
//        String res = restTemplate.getForObject("http://stock-service/stock/reduce", String.class);
        String res = stockFeignService.reduct();
        return "添加商品"+res;
    }

    @GetMapping("/total")
    public Integer getOrderTotal() {
        return orderTotal;
    }
}
