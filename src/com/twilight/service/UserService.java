package com.twilight.service;

import com.twilight.pojo.User;

public interface UserService {
    public void regist(User user);

    public User login(String username,String password);
}
