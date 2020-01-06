package com.cskaoyan.mapper;

import com.cskaoyan.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserById(@Param("id") Integer id);
}
