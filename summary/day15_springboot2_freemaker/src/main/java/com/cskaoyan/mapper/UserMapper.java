package com.cskaoyan.mapper;

import com.cskaoyan.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUserByIda(@Param("id") Integer id);
}
