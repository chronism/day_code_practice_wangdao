package com.cskaoyan.mapper;

import com.cskaoyan.domain.User;

public interface UserMapper {

    User queryUser(User user);

    void insertUser(User user);

    void deleteUser(String username);

    void updateUser(String username,User user);
}
