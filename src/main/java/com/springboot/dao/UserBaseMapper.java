package com.springboot.dao;

import com.springboot.domain.UserBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserBaseMapper {
    @Select("select * from user_base where user_id = #{userId}")
    public UserBase selectUserBaseByUserId(int userId);
    @Select("select * from user_base where username = #{username}")
    public UserBase selectUserBaseByUserName(String username);

}
