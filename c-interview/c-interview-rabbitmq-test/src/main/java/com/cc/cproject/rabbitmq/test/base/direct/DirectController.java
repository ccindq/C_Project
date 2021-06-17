package com.cc.cproject.rabbitmq.test.base.direct;

import com.cc.cproject.rabbitmq.producer.DirectSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectController {


    @Autowired
    DirectSender directSender;

    @RequestMapping("/directTest")
    public void directSendMessage() {
        directSender.send(1);
    }

}
