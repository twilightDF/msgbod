package com.twilight.service;

import com.twilight.dao.UserDao;
import com.twilight.dao.UserDaoImpl;
import com.twilight.pojo.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void regist(User user) {
        userDao.addUser(user);
    }

    @Override
    public User login(String username,String password) {
        User user = userDao.queryUserByUsernameAndPassword(username,password);
        return user;
    }
}
