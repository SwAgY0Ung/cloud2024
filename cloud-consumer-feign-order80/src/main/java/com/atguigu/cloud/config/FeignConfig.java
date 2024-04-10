package com.atguigu.cloud.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Echo
 * @date 2024/4/10
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer myRetryer() {
        //feign的默认配置是这个，默认不重试
        //return Retryer.NEVER_RETRY;
        //最大请求次数是3， 初始间隔时间是100ms， 重试间最大间隔是1s
        return new Retryer.Default(100, 1, 3);
    }
}
