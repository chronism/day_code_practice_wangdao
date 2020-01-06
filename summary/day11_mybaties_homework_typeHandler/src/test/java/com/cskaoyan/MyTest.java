package com.cskaoyan;

import com.cskaoyan.domain.UserDetail;

import com.cskaoyan.domain.User;
import com.cskaoyan.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

public class MyTest {


    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void myTest() throws IOException {

        /* Resources是mybaties的  */
        inputStream = Resources.getResourceAsStream("mybaties.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After
    public void myTest2() throws IOException {
        if (inputStream != null) {
            inputStream.close();
            ;
        }
        if (sqlSession != null) {
            /* 一定要提交事务 */
            sqlSession.commit();
            ;
            sqlSession.close();
        }
    }

    @Test
    public void myTest3() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setUsername("lisi");
        user.setPassword("123433");
        user.setAge(20);
        user.setGender("male");
        UserDetail userDetail = new UserDetail();
        userDetail.setId(2);
        userDetail.setEmail("sfdss@dsa");
        userDetail.setPhone("3grds6");
        user.setUserDetail(userDetail);
        Integer integer = mapper.insertUser(user);
        System.out.println(integer);
    }

    @Test
    public void myTest4() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsdan");
        user.setPassword("123");
        User user1 = mapper.queryUser(user);
        System.out.println(user1);

    }

    @Test
    public void myTest5() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserDetail userDetail = new UserDetail();
        userDetail.setId(1);
        userDetail.setEmail("dsaas@dsa");
        userDetail.setPhone("3435436");
        User user = mapper.queryUserByParams("zhangsdan", "123", 34, null);
        System.out.println(user);
    }
}
