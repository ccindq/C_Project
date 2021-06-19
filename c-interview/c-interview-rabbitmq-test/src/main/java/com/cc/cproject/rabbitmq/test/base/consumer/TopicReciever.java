package com.cc.cproject.rabbitmq.test.base.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = {"topicQueueA"})
public class TopicReciever {
    private static final Logger logger = LoggerFactory.getLogger(TopicReciever.class);

    @RabbitHandler
    public void receiverMsg(String msg) {
        logger.info("class:{},message:{}", "TopicReceiverA", msg);
    }
}
