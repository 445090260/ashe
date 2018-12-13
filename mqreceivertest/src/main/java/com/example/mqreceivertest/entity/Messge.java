package com.example.mqreceivertest.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class Messge {
    private String status;
    private String messge;

}
