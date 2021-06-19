package com.cc.cproject.rabbitmq.test.controller;

import com.cc.cproject.rabbitmq.test.base.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

    @Autowired
    WorkQueueSender workQueueSender;

    @Autowired
    SimpleSender simpleSender;

    @Autowired
    TopicSender topicSender;

    @Autowired
    FanoutProducer fanoutProducer;

    @Autowired
    DirectSender directSender;


    @RequestMapping("/workqueue")
    public void workqueueSend() {
        simpleSender.send(1);
    }

    @RequestMapping("/fanout")
    public void fanoutSend() {
        fanoutProducer.send(123);

    }

    @RequestMapping("/topic")
    public void topicSend() {
        topicSender.send1();
        topicSender.send2();
    }

    @RequestMapping("/direct")
    public void directSend() {
        directSender.send(1);
    }

    @RequestMapping("/simple")
    public void simpleSend() {
        simpleSender.send(1);
    }
}
