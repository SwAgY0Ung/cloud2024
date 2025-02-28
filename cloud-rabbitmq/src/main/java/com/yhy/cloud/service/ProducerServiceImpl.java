package com.yhy.cloud.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * 生产者实现类（发送消息的
 *
 * @author Echo
 * @date 2025/2/28 11:34
 */
@Service
public class ProducerServiceImpl {
    @Resource
    private RabbitTemplate rabbitTemplate;

//    @PostConstruct
    public void senMessage() {
        String exchange = "TEST-EXCHANGE";
        String routingKey = "test.yhy";
        for (int i = 1; i <= 50; i++) {
            System.out.println("发送消息：" + i);
            rabbitTemplate.convertAndSend(exchange, routingKey, i); // 交换机、路由键、消息
        }

    }
}
