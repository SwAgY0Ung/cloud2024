package com.atguigu.cloud.cloudalibabasentinelservice8401.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.cloud.cloudalibabasentinelservice8401.service.CommonService;
import org.springframework.stereotype.Service;

/**
 * @Auther yhy
 * @Date 2025/1/2 22:54
 */
@Service

public class CommonServiceImpl implements CommonService {

    @SentinelResource("common") //该注解意思是该方法注入成sentinel的资源，可以被监控到
    @Override
    public String common() {
        return "common方法调用";
    }
}
