package com.cc.cproject.rabbitmq.autoconfigure;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQFanoutExchange {

    @Bean("fanoutQueueA")
    public Queue fanoutQueueA(){
        return new Queue("fanoutQueueA", true, true, true);
    }

    @Bean("fanoutQueueB")
    public Queue fanoutQueueB(){
        return new Queue("fanoutQueueB", true, true, true);
    }

    @Bean("fanoutQueueC")
    public Queue fanoutQueueC(){
        return new Queue("fanoutQueueC", true, true, true);
    }

    /**
     * 声明一个Fanout类型的交换器
     * @Author mazq
     * @Date 2020/04/08 11:25
     * @Param []
     * @return org.springframework.amqp.core.FanoutExchange
     */
    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding fanoutABinding(@Qualifier("fanoutQueueA")Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBBinding(@Qualifier("fanoutQueueB")Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutCBinding(@Qualifier("fanoutQueueC")Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

}
