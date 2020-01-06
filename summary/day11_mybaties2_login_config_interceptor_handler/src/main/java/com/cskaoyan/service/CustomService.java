package com.cskaoyan.service;

import com.cskaoyan.domain.User;

public interface CustomService {
    Boolean queryUser(User user);

    void updateUser(String username,User user);

    void insertUser(User user);

    void deleteUser(String username);
}
