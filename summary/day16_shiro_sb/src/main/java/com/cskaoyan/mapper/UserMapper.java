package com.cskaoyan.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select password from a_users where username = #{username}")
    List<String> selectPasswordByName(@Param("username") String username);

    @Select("SELECT DISTINCT a_permission.permissionName\n" +
            "from a_users\n" +
            "LEFT JOIN a_u_r on a_u_r.uid =a_users.id\n" +
            "LEFT JOIN a_roles ON\ta_roles.id=a_u_r.rid\n" +
            "LEFT JOIN a_r_p ON a_r_p.rid= a_roles.id\n" +
            "LEFT JOIN a_permission on a_permission.id=a_r_p.pid\n" +
            "where username=#{username} ; ")
    List<String> selectPermissionByUsername(@Param("username") String username);
}
