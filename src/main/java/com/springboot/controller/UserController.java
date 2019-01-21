package com.springboot.controller;

import com.springboot.constant.ServerResponse;
import com.springboot.domain.UserBase;
import com.springboot.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    /***
     *   登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    public ServerResponse<UserBase> login(String username, String password ){
        ServerResponse<UserBase> userServerResponse = iUserService.login(username,password);
        if(userServerResponse.isSuccess()){
            Session session= SecurityUtils.getSubject().getSession();
            session.setAttribute("userbase",userServerResponse.getData());
        }
        return userServerResponse;

    }
    /**
     *  用户注册
     *
     */
    @PostMapping("/register")
    public ServerResponse<String> register(UserBase userBase){
        return iUserService.register(userBase);
    }
}
