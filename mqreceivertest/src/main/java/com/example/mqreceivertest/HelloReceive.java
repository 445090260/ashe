package com.example.mqreceivertest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceive {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

}