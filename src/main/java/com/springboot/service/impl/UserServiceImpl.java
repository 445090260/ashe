package com.springboot.service.impl;

import com.springboot.constant.Const;
import com.springboot.constant.ServerResponse;
import com.springboot.dao.UserBaseMapper;
import com.springboot.domain.UserBase;
import com.springboot.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
    /**
     *  用户注册
     * @param userBase
     *
     * @return
     */
    @Override
    public ServerResponse<String> register(UserBase userBase){

        ServerResponse usernameServerResponse = this.checkVaild(userBase.getUserName(),Const.USERNAME);
        if(!usernameServerResponse.isSuccess()){ // 已注册
            return usernameServerResponse;
        }
        ServerResponse emailServerResponse = this.checkVaild(userBase.getEmail(),Const.EMAIL);
        if(!usernameServerResponse.isSuccess()){// 已注册
            return emailServerResponse;
        }
        ServerResponse phoneServerResponse = this.checkVaild(userBase.getEmail(),Const.PHONE);
        if(!usernameServerResponse.isSuccess()){// 已注册
            return phoneServerResponse;
        }

        ByteSource credentialsSalt = ByteSource.Util.bytes(userBase.getUserName());    //盐
        userBase.setPassword(new SimpleHash("MD5",userBase.getPassword(),credentialsSalt,1024).toString());

        int userCount = userBaseMapper.insertUserBase(userBase);
        if(userCount==0){
            return ServerResponse.createByErrorMessage("注册失败");
        }

        return ServerResponse.createBySuccessMessage("注册成功");


    }


    /***
     *  校验用户名和email的唯一性
     * @param name
     * @param type
     * @return
     */
    public ServerResponse checkVaild(String name,String type){

        if(StringUtils.isNotBlank(type)){

            if(Const.USERNAME.equals(type)){

                int count = userBaseMapper.checkUserName(name);
                if(count>0){
                    return  ServerResponse.createByErrorMessage("用户名已存在");
                }

            }

            if(Const.EMAIL.equals(type)){
                int count = userBaseMapper.checkEmail(name);
                if(count>0){
                    return  ServerResponse.createByErrorMessage("邮箱已存在");
                }

            }
            if(Const.PHONE.equals(type)){
                int count = userBaseMapper.checkPhone(name);
                if(count>0){
                    return  ServerResponse.createByErrorMessage("手机号已存在");
                }

            }

        }else{

            return ServerResponse.createByErrorMessage("type这个参数有误");
        }

        return ServerResponse.createBySuccessMessage("校验成功");

    }
}
