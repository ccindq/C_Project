package com.cc.cproject.rabbitmq.autoconfigure;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQDirectExchange {

    /**
     * 声明直连交换机 支持持久化.
     * @return the exchange
     */
    @Bean("directExchange")
    public Exchange directExchange() {
        return ExchangeBuilder.directExchange("amq.direct").durable(true).build();
    }

    @Bean("directQueue")
    public Queue directQueue(){
        return new Queue("directQueue", true, true, true);
        //return QueueBuilder.durable("directQueue").build();
    }

    @Bean
    public Binding directBinding(@Qualifier("directQueue")Queue queue, @Qualifier("directExchange")Exchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("direct_routingKey").noargs();
    }
}
