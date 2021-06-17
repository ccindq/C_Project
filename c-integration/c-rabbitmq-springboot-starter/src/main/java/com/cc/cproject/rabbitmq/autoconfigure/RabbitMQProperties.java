package com.cc.cproject.rabbitmq.autoconfigure;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "c.project.rabbitmq")
public class RabbitMQProperties {

    private boolean enable;

}
