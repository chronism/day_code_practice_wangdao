/*
package com.cskaoyan.typeHandler;


import com.cskaoyan.domain.UserDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@MappedTypes(UserDetail.class)
public class String2UserTypeHandler implements TypeHandler<UserDetail> {


    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, UserDetail userDetail, JdbcType jdbcType) throws SQLException {

        String s = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
             s = objectMapper.writeValueAsString(userDetail);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        preparedStatement.setString(index,s);
    }

    @Override
    public UserDetail getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return transfer(string);
    }

    private UserDetail transfer(String string) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserDetail userDetail = null;
        try {
             userDetail = objectMapper.readValue(string, UserDetail.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userDetail;
    }

    @Override
    public UserDetail getResult(ResultSet resultSet, int index) throws SQLException {
        String string = resultSet.getString(index);
        return transfer(string);
    }

    @Override
    public UserDetail getResult(CallableStatement callableStatement, int index) throws SQLException {
        String string = callableStatement.getString(index);
        return transfer(string);
    }
}
*/
