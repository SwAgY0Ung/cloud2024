package com.yhy.cloud.service;

import jakarta.annotation.Resource;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者实现类（接收消息的
 *
 * @author Echo
 * @date 2025/2/28 11:35
 */
@Service
public class ConsumerServiceImpl {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "TEST-QUEUE", durable = "true"),
            exchange = @Exchange(name = "TEST-EXCHANGE"),
            key = "test.yhy"
    ))
    public void receive(String message) throws InterruptedException {
        System.out.println("消费者接收到消息：" + message);
//        Thread.sleep(100000000);
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8001/test", String.class);
    }
}
