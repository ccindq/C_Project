package com.cc.cproject.rabbitmq.test.base.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WorkQueueSender {

    private static final Logger logger = LoggerFactory.getLogger(WorkQueueSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void work() throws InterruptedException {
        String msg = "这是一个work模式";
        for (int i = 0; i < 10; i++) {
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            logger.info("class:{},message:{}", "WorkQueueSender", msg);
            rabbitTemplate.convertAndSend("spring.work.queue", (Object) (msg + i),correlationData);
            Thread.sleep(5000);
        }
    }
}
