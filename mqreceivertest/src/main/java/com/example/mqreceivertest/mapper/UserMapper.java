package com.example.mqreceivertest.mapper;

import com.example.mqreceivertest.entity.Order;
import com.example.mqreceivertest.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

//    @Select("select * from hc_user where user_id = #{id}")
//    public User selectUserById(int id);
//
//    @Select("select * from hc_user where user_name = #{userName}")
//    public List<User> selectUserByName(String userName);
//
//    @Select("select * from hc_user where user_username = #{userName}")
//    public User selectUserByUserName(String userName);
//
//    @Insert("insert into hc_user(user_username,user_phone,user_password,user_email) values (#{userUserName},#{userPhone},#{userPassword},#{userEmail})")
//    public void addUser(User user);
//
//    @Update("update hc_user set user_name=#{userName},user_phone=#{userPhone} where id=#{id}")
//    public void updateUser(User user);
//
//    @Delete("delete from hc_order where user_id=#{id}")
//    public void deleteUser(int id);

    @Insert("insert into hc_order(user_username,order_number,date_time,product_name) values (#{userName},#{orderNumber},#{dateTime},#{productName})")
    public void addOrder(Order userorder);
    @Update("update hc_product set stock=stock-1 where product_name=#{productName}")
   public void decrStock(String productName);



}
