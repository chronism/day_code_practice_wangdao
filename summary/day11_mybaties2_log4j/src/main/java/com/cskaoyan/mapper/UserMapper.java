package com.cskaoyan.mapper;

import com.cskaoyan.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUserNameById(Integer id);

    List<User> selectUserById(Integer id);
}
