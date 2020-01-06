package com.cskaoyan.typeHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class String2JsonTypeHandler implements TypeHandler<String[]> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString=null;
        try {
             valueAsString = objectMapper.writeValueAsString(strings);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        preparedStatement.setString(i,valueAsString);
    }

    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return transfer(string);
    }

    private String[] transfer(String s1) {
        ObjectMapper objectMapper = new ObjectMapper();
        String[] strings=null;
        try {
            strings = objectMapper.readValue(s1, String[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return strings;
    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return transfer(string);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return transfer(string);
    }
}
