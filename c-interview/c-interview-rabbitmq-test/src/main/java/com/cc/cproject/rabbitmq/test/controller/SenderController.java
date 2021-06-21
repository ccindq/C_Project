package com.cc.cproject.rabbitmq.test.controller;

import com.cc.cproject.rabbitmq.test.base.producer.*;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    WorkQueueSender workQueueSender;

    @Autowired
    SimpleSender simpleSender;

    @Autowired
    TopicSender topicSender;

    @Autowired
    FanoutSender fanoutProducer;

    @Autowired
    DirectSender directSender;


    @RequestMapping("/workqueue")
    public void workqueueSend() throws InterruptedException {
        workQueueSender.work();
    }

    @RequestMapping("/fanout")
    public void fanoutSend(String msg) {
        fanoutProducer.send(msg);

    }

    @RequestMapping("/topic")
    public void topicSend(String msg, String routingKey) {
        topicSender.send(msg, routingKey);
    }

    @RequestMapping("/direct")
    public void directSend(String msg) {
        directSender.send(msg);
    }

    @RequestMapping("/simple")
    public void simpleSend(String msg) {
        simpleSender.send(msg);
    }

    public void getMessageCount() {

        String queue = "direct.screenshot.queue";

        AMQP.Queue.DeclareOk declareOk = rabbitTemplate.execute(new ChannelCallback<AMQP.Queue.DeclareOk>() {
            public AMQP.Queue.DeclareOk doInRabbit(Channel channel) throws Exception {
                return channel.queueDeclarePassive(queue);
            }


        });

        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println(declareOk.getMessageCount());
    }

}
