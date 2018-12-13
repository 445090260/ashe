package com.example.mqreceivertest;

import com.example.mqreceivertest.entity.Order;
import com.example.mqreceivertest.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;

@Component

@RabbitListener(queues = "Order")
public class HelloReceive {
    @Autowired
    Order userOrder;
    @Autowired
    ObjectMapper mapper;

    @Autowired
    UserMapper test;
    @RabbitHandler
    public void process(String json) throws IOException {
    userOrder=mapper.readValue(json,Order.class);
        TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(tz);
        System.out.println(new Date());
        userOrder.setDateTime(new java.sql.Date(new Date().getTime()));
        userOrder.setOrderNumber(new Date());
        test.addOrder(userOrder);
        test.decrStock(userOrder.getProductName());
        System.out.println("Receiver  : " + userOrder.getProductName());
    }

}