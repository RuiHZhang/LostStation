package com.zrh.service.impl;

import com.zrh.dao.UserDao;
import com.zrh.pojo.User;
import com.zrh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String userpass) {
        return userDao.login(username,userpass);
    }

    @Override
    public boolean register(User user) {
        int register = userDao.register(user);
        return register > 0;
    }

    @Override
    public User getUserById(int userid) {
        return userDao.getUserById(userid);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user) > 0;
    }

    @Override
    public List<String> getAllUserName() {
        return userDao.getAllUserName();
    }
}
