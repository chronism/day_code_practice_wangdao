package com.cskaoyan;

import com.cskaoyan.domain.User;
import com.cskaoyan.domain.UserDetail;
import com.cskaoyan.domain.UserExample;
import com.cskaoyan.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class MyTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;


    Logger logger = Logger.getLogger(this.getClass());


    @Before
    public void before() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
    }

    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void myTest() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(23);
        user.setUsername("zzzzzzzz");
        user.setPassword("fdsfgd43");
        user.setMoney(2423);
        int insert = mapper.insert(user);
        logger.info(insert);
    }

    @Test
    public void myTest2() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(25);
        user.setUsername("fsdfzz");
        user.setPassword("fdsfgd43");
        user.setMoney(2423);
        int insert = mapper.insertSelective(user);
        logger.info(insert);
    }

    @Test
    public void myTest3() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIsNotNull();
        List<User> users = mapper.selectByExample(userExample);
        for (User user : users) {
            logger.info(user);
        }
    }
}