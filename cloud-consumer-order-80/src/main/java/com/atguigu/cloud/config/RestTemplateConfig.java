package com.atguigu.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Echo
 * @date 2024/3/27
 */
@Configuration
public class RestTemplateConfig {

    //注入容器
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
