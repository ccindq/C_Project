package com.cc.cproject.rabbitmq.test.base.consumer;


import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * 轮询分发(round-robin)：MQ不管两个消费者谁忙，数据总是你一个我一个，MQ 给两个消费发数据的时候是不知道消费者性能的，默认就是雨露均沾。
 * 此时 autoAck = true。
 * 公平分发：要让消费者消费完毕一条数据后就告知MQ，再让MQ发数据即可。自动应答要关闭，实现按照消费者性能消费。
 *
 */
@Component
public class WorkQueueReciever {


    // 通过注解自动创建 spring.work.queue 队列
    @RabbitListener(queuesToDeclare = @Queue("spring.work.queue"))
    public void listen(String msg) {
        System.out.println("work模式 接收到消息：" + msg);
    }

    // 创建两个队列共同消费
    @RabbitListener(queuesToDeclare = @Queue("spring.work.queue"))
    public void listen2(String msg) {
        System.out.println("work模式二 接收到消息：" + msg);
    }


}
