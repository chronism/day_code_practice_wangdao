package com.cskaoyan.service.Impl;


import com.cskaoyan.domain.User;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String queryUserNameById(Integer id) {
        User user = userMapper.queryUserById(id);

        return user.getUsername();
    }
}
