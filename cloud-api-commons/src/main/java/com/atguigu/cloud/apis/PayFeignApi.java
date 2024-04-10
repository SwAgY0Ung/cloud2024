package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Echo
 * @date 2024/4/8
 */
@FeignClient("cloud-payment-service")
public interface PayFeignApi {
    /**
     * 查询全部
     * @return list<实体类>
     */
    @GetMapping("/pay/getAll")
    ResultData getAll();
}
