package com.cskaoyan.typeHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* 要注解声明 */
@MappedTypes(String[].class)
public class String2StringsTypeHandler implements TypeHandler<String[]> {

    /* 第二个参数i 就是index ,第三个参数是object o 就是传入的参数，这里指的是String[] */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        /* ObjectMapper是json类，这个用到了Jackson的数据封装转换 */
        String s = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            s = objectMapper.writeValueAsString(strings);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        /* 这是存入过程 */
        preparedStatement.setString(i, s);
    }


    /* 下面的都是取出数据,并封装成String[]，数据库里面的json数组格式最好写成
     *["sing","dance"]
     * */

    /* 第二个参数可以认为是column */
    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        /* 这只是从数据库里面取出String（Json） ，还需要转换一下*/
        String resultSetString = resultSet.getString(s);

        return transfer(resultSetString);
    }

    /*  手动写的转换器  */
    private String[] transfer(String resultSetString) {

        /*  还是借助了Json */
        ObjectMapper objectMapper = new ObjectMapper();
        String[] strings = null;
        try {
            strings = objectMapper.readValue(resultSetString, String[].class);
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
