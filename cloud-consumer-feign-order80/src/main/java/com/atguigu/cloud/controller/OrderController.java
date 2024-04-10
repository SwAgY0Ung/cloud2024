package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entites.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Echo
 * @date 2024/3/27
 */
@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/getAll")
    public ResultData getAll() {
        ResultData resultData;
        System.out.println("服务调用开始"+ LocalDateTime.now());
        try {
            resultData = payFeignApi.getAll();
        } catch (Exception e) {
            System.out.println("服务调用结束"+ LocalDateTime.now());
            return ResultData.fail("62","调用超时");
        }
        return resultData;
    }

}
