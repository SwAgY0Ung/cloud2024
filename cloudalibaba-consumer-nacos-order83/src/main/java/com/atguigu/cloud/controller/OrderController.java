package com.atguigu.cloud.controller;

import com.atguigu.cloud.feignClient.PayClient;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private PayClient payClient;

    @GetMapping("/getPayment")
    public String getPayment() {
        System.out.println("getPayment接口被调用...");
        String payInfo = payClient.getPayInfo("1");
        return payInfo;
    }
}
