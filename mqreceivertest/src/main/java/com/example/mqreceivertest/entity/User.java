package com.example.mqreceivertest.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class User {
    private Long userId;
    private String userUserName;
    private String userPhone;
    private String userEmail;
    private String userPassword;
}
