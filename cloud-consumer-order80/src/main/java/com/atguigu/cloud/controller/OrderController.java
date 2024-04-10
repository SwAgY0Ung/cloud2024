package com.atguigu.cloud.controller;

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

import java.util.List;

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

    //注入服务发现客户端
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery() {
        //获取所有服务
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        //获取名称为cloud-payment-service这个服务的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }



}
