package com.example.mqreceivertest.entity;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@Getter
@Setter
@Component
public class Order {
    private String userName;
    private String productName;
    private long orderNumber ;
    private Date dateTime;
    public void setOrderNumber(Date time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(time);
        Random random = new Random();
        long s = (random.nextInt(99999)%(99999-10000+1) + 10000);
        orderNumber =  Long.parseLong(s+dateString);
    }



}
