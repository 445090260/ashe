package com.springboot.service;

import com.springboot.constant.ServerResponse;
import com.springboot.domain.UserBase;

public interface IUserService {
    ServerResponse<UserBase> login(String username, String password);
    ServerResponse<String> register(UserBase user);
}
