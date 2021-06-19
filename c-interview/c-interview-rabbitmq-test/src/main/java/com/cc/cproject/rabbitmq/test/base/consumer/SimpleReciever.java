package com.cc.cproject.rabbitmq.test.base.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleReciever {

    // 通过注解自动创建 spring.simple.queue 队列
    @RabbitListener(queuesToDeclare = @Queue("spring.simple.queue"))
    public void listen(String msg) {
        System.out.println("简单队列 接收到消息：" + msg);
    }

}
