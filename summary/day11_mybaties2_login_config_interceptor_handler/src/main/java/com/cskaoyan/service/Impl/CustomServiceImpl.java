package com.cskaoyan.service.Impl;

import com.cskaoyan.domain.User;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.service.CustomService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;

@Service
public class CustomServiceImpl implements CustomService {


    static SqlSessionFactory sqlSessionFactory;
    static InputStream inputStream = null;

    static {
        try {
            inputStream = Resources.getResourceAsStream("mybaties.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Override
    public Boolean queryUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.queryUser(user);
        close(sqlSession);

        if (user1 == null) {
            return false;
        }
        return true;
    }

    @Override
    public void updateUser(String username, User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(username, user);
        close(sqlSession);
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUser(user);
        close(sqlSession);
    }

    @Override
    public void deleteUser(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(username);
        close(sqlSession);
    }


    private void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
