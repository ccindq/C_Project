package com.cc.cproject.rabbitmq.autoconfigure;


import com.cc.cproject.rabbitmq.producer.RabbitMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(RabbitMQProducer.class)
@ConditionalOnProperty(prefix = "c.project.rabbitmq", value = "enable", matchIfMissing = true)
@EnableConfigurationProperties(RabbitMQProperties.class)
public class RabbitMQAutoConfigure {

    private static final Logger logger= LoggerFactory.getLogger(RabbitMQAutoConfigure.class);

    @Autowired
    private RabbitMQProperties rabbitMQProperties;

    @Bean
    public RabbitMQProducer rabbitMQProducer() {
        return new RabbitMQProducer(rabbitMQProperties);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    //@Primary
    public AmqpTemplate amqpTemplate(){
        //使用jackson 消息转换器(发送对象时候才开启)
        //rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
        rabbitTemplate.setMandatory(true);
        // 开启returncallback    yml 需要配置publisher-returns: true
        rabbitTemplate.setReturnCallback(((message,  replyCode, replyText, exchange, routingKey) -> {
            String correlationId = message.getMessageProperties().getCorrelationId();
            logger.info("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
        }));
        //开启消息确认  yml 需要配置   publisher-returns: true
        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) ->{
            if (ack) {
                logger.info("消息发送到交换机成功,correlationId:{}",correlationData.getId());
            } else {
                logger.info("消息发送到交换机失败,原因:{}",cause);
            }
        } ));
        return rabbitTemplate;
    }

}
