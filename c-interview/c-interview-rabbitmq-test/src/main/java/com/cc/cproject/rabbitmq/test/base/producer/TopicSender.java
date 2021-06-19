package com.cc.cproject.rabbitmq.test.base.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class TopicSender {

    private static final Logger logger = LoggerFactory.getLogger(TopicSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send1() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String content = "hello!" + date;
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("class:{},message:{}", "TopicSender", content);
        this.rabbitTemplate.convertAndSend("amq.topic", "topic.msg", content, correlationData);
    }

    public void send2() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String content = "hello!" + date;
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("class:{},message:{}", "TopicSender", content);
        this.rabbitTemplate.convertAndSend("amq.topic", "topic.msg1", content, correlationData);
    }
}
