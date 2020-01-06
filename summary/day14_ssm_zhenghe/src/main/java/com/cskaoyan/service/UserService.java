package com.cskaoyan.service;

import com.cskaoyan.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    String queryUserNameById(Integer id);
}
