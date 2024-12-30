package com.atguigu.cloud.feignClient;

import jakarta.annotation.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("nacos-payment-provider")
public interface PayClient {
    @GetMapping("/pay/nacos/{id}")
    String getPayInfo(@PathVariable("id") String id);
}
