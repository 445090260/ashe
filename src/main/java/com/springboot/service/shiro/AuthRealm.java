package com.springboot.service.shiro;

import com.springboot.dao.UserBaseMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
public class AuthRealm extends AuthorizingRealm {
    private HashedCredentialsMatcher credentialsMatcher;
    @Autowired
    private UserBaseMapper userBaseMapper;

    //加密
    @Override
    public HashedCredentialsMatcher getCredentialsMatcher() {
        credentialsMatcher=new HashedCredentialsMatcher("MD5");
        credentialsMatcher.setHashIterations(1024);
        return credentialsMatcher;
    }

    //登陆
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken=(UsernamePasswordToken)authenticationToken;
        String username =userToken.getUsername();
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        Object credentials=userBaseMapper.selectUserBaseByUserName(username);
        return new SimpleAuthenticationInfo(username,credentials,credentialsSalt,this.getName());
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object principal=principalCollection.getPrimaryPrincipal();
        Set<String> roles=new HashSet<>();
        if(principal.equals("admin")) {
            roles.add("admin") ;
      }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);
        return info;
    }

}
