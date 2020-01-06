package com.cskaoyan.mapper;

import com.cskaoyan.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UseraMapper {
    User selectUserById(@Param("id") Integer id);

    User selectUserByName(@Param("username") String username);

    int upDateMoneyById(@Param("id") Integer id, @Param("money") int money);

    int upDateMoneyByUsername(@Param("username") String username, @Param("money") int money);

}
