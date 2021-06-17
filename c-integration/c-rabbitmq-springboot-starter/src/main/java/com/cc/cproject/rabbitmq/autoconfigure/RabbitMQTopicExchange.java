package com.cc.cproject.rabbitmq.autoconfigure;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQTopicExchange {

    @Bean("topicQueueA")
    public Queue topicQueueA() {
        return new Queue("topicQueueA", true, true, true);
    }

    @Bean("topicQueueB")
    public Queue topicQueueB() {
        return new Queue("topicQueueB", true, true, true);
    }

    @Bean("topicExchange")
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding topicABinding(@Qualifier("topicQueueA") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("topic.msg");
    }

    @Bean
    public Binding topicBBinding(@Qualifier("topicQueueB") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("topic.#");
    }


}
