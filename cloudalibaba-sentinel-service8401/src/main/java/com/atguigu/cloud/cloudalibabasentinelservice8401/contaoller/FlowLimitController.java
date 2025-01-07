package com.atguigu.cloud.cloudalibabasentinelservice8401.contaoller;

import com.atguigu.cloud.cloudalibabasentinelservice8401.service.CommonService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther yhy
 * @Date 2024/12/30 22:38
 */
@RestController
public class FlowLimitController {

    @Resource
    private CommonService commonService;

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    //同样都是调用common，监控C链路，D链路放行

    @GetMapping("/testC")
    public String testC() {
        return commonService.common();
    }

    @GetMapping("/testD")
    public String testD() {
        return commonService.common();
    }
}
