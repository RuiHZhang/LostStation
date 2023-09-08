package com.zrh.service;

import com.zrh.pojo.User;

import java.util.List;

public interface UserService {
//    用户登录方法
    User login(String username, String userpass);

    //用户注册方法
    boolean register(User user);

    //根据用户id获取用户
    User getUserById(int userid);

    //更新用户信息，包含头像上传
    boolean updateUser(User user);

    //获取所有存在的用户名，用于注册时验证用户名是否存在
    List<String> getAllUserName();
}
