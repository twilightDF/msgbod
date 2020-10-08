package com.twilight.dao;

import com.twilight.pojo.User;

public interface UserDao {
    public void addUser(User user);

    public User queryUserByUsernameAndPassword(String username,String password);
}
