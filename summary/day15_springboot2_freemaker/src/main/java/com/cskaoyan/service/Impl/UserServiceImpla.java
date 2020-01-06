package com.cskaoyan.service.Impl;

import com.cskaoyan.domain.User;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.service.UserServicea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpla implements UserServicea {


    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserById(Integer id) {
        User user = userMapper.selectUserByIda(id);
        return user;
    }
}
