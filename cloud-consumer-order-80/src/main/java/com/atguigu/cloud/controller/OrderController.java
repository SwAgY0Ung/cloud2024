package com.atguigu.cloud.controller;

import com.atguigu.cloud.entites.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Echo
 * @date 2024/3/27
 */
@RestController
public class OrderController {

//    public static final String PaymentSrv_URL = "http://localhost:8001";
    //引入consul之后直接使用服务名就可以
    private String PaymentSrv_URL = "http://cloud-payment-service:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add", payDTO, ResultData.class);
    }

    @GetMapping("/consumer/pay/del/{id}")
    public ResultData delOrder(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/del/"+id, ResultData.class);
    }

    @GetMapping("consumer/pay/get/{key}")
    public ResultData getOrder(@PathVariable("key") Integer key) {
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+key, ResultData.class);
    }

    @PostMapping("/consumer/update")
    public ResultData updateOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL+"/update", payDTO, ResultData.class);
    }

}
