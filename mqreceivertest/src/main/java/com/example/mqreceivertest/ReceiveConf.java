package com.example.mqreceivertest;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiveConf {
    @Bean
    public Queue queue() {
        return new Queue("hello");
    }
}