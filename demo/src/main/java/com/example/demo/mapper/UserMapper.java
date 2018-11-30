package com.example.demo.mapper;
import com.example.demo.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from hc_user where user_id = #{id}")
    public User selectUserById(int id);

    @Select("select * from hc_user where user_name = #{userName}")
    public List<User> selectUserByName(String userName);

    @Insert("insert into hc_user(user_name,user_phone) values (#{userName},#{userPhone})")
    public void addUser(User user);

    @Update("update hc_user set user_name=#{userName},user_phone=#{userPhone} where id=#{id}")
    public void updateUser(User user);

    @Delete("delete from hc_user where user_id=#{id}")
    public void deleteUser(int id);


}
