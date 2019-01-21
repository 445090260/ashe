package com.springboot.dao;

import com.springboot.domain.UserBase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserBaseMapper {
    @Select("select * from user_base where user_id = #{userId}")
    public UserBase selectUserBaseByUserId(int userId);
    @Select("select * from user_base where username = #{username}")
    public UserBase selectUserBaseByUserName(String userName);
    @Select("select count(1) from user_base where phone = #{phone}")
    public int checkUserName(String userName);
    @Select("select count(1) from user_base where email = #{email}")
    public int checkEmail(String email);
    @Select("select count(1) from user_base where phone = #{phone}")
    public int checkPhone(String phone);
    @Insert("insert into user_base(username,phone,email,password) values (#{username},#{phone},#{email},#{password})")
    public int insertUserBase(UserBase userBase);
}
