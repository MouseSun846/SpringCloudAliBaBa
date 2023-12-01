package com.lsy.fegin;

import com.lsy.configure.CustomLoadBalancerConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="stock-service", path ="/stock")
public interface StockFeignService {
    //声明需要调用的rst接口对应的方法
    @RequestMapping("/reduce")
    String reduct();
}
