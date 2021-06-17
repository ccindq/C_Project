package com.cc.cproject.rabbitmq.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"fanoutQueueB"})
public class FanoutRecieverB {

    private static final Logger logger = LoggerFactory.getLogger(FanoutRecieverB.class);

    @RabbitHandler
    public void process(String hello) {
        logger.info("BReceiver  : " + hello + "/n");
    }

}
