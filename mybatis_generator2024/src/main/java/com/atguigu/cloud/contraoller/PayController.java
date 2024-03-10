package com.atguigu.cloud.contraoller;

import com.atguigu.cloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Echo
 * @date 2024/3/10
 */
@RestController
public class PayController {

    @Autowired
    private PayService service;

    @GetMapping("/getByKey/{key}")
    public String getByKey(@PathVariable String key) {
        return service.getByKey(key);
    }
}
