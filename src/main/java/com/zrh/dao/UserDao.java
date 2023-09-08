package com.zrh.dao;

import com.zrh.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //用户登录方法
    User login(@Param("username") String username, @Param("userpass") String userpass);

    //用户注册方法
    int register(User user);

    //根据用户id获取用户信息
    User getUserById(int userid);

    //用户修改方法
    int updateUser(User user);

    //获取所有用户名方法，用户注册验证用户名是否存在
    List<String> getAllUserName();
}
