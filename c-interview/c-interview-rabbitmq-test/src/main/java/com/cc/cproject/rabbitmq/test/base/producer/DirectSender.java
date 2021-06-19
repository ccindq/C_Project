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
public class DirectSender {

    private static final Logger logger = LoggerFactory.getLogger(DirectSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int i) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String content = i + ":hello!" + date;
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("class:{},message:{}", "DirectSender", content);
        this.rabbitTemplate.convertAndSend("amq.direct", "direct_routingKey", content, correlationData);
    }
}
