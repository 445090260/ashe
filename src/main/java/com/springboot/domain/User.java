package com.springboot.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class User {
    //user_base
    private Long user_id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String status;
    //user_profile
    private String realname;
    private String sex;
    private String level;
    private String experience;
    private String personal_title;
    private String face_url;
    private String birthday;
    private String regist_ip;
    private String regist_time;
    private String login_ip;
    private String login_time;
    private String login_count;
    private String online_status;
    private String unreadmsg;
    //user_security_conf
    private String question1;
    private String answer1;
    private String question2;
    private String answer2;
    private String question3;
    private String answer3;
    //user_system_conf
    private String payset;
    private String theme;
    private String lang;
    private String cert_type;
    private String cert_no;
    private String cert_exp;

}
