package com.springboot.service.impl;

import com.springboot.constant.ServerResponse;
import com.springboot.dao.UserBaseMapper;
import com.springboot.domain.UserBase;
import com.springboot.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserBaseMapper userBaseMapper;
    @Override
    public ServerResponse<UserBase> login(String username, String password) {
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try{
            SecurityUtils.getSubject().login(token);
        }
        catch (AuthenticationException e){
            return ServerResponse.createByErrorMessage("用户名/密码错误");
        }catch (Exception e){
            ServerResponse.createByErrorMessage("服务器错误，请稍后在试");
        }
        UserBase userBase=userBaseMapper.selectUserBaseByUserName(username);
        userBase.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccessMsgAndData("登陆成功",userBase);
    }

    @Override
    public ServerResponse<String> register(UserBase userBase) {
        return ServerResponse.createByErrorMessage("测试");
    }
}
