package com.cc.cproject.rabbitmq.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"fanoutQueueC"})
public class FanoutRecieverC {

    private static final Logger logger = LoggerFactory.getLogger(FanoutRecieverC.class);

    @RabbitHandler
    public void process(String hello) {
        logger.info("CReceiver  : " + hello + "/n");
    }

}
