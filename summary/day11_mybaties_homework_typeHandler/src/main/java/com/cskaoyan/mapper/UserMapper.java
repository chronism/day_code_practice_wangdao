package com.cskaoyan.mapper;

import com.cskaoyan.domain.User;
import com.cskaoyan.domain.UserDetail;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    Integer insertUser(User user);

    User queryUser(User user);

    User queryUserByParams(@Param("username") String username, @Param("password") String password, @Param("age") Integer age, @Param("userDetail") UserDetail userDetail);
}
