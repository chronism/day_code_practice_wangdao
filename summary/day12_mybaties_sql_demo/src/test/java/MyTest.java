package com.cskaoyan.mytest;

import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
    }
    @After
    public void after(){
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void mytest(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByIdOne2One(1);
        System.out.println(user);
    }

    @Test
    public void mytest2(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByIdOne2OneLeft(1);
        System.out.println(user);
    }

    @Test
    public void mytest3(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.queryUsersByIdOne2Many(1);
        for (User user:users) {
            System.out.println(user);
        }

    }

    @Test
    public void mytest4(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        /*List<User> users = userMapper.queryUsersByIdOne2Many(1);
        for (User user:users) {
            System.out.println(user);
        }*/
        List<User> userList = userMapper.queryCoursesByUserIdMany2Many(1);
        for (User user : userList) {
            System.out.println(user);

        }

    }


    @Test
    public void mytest5(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User userByParams = userMapper.findUserByParams(1, null, null);
        User userByParams = userMapper.findUserByParams(null, "zhangsan", null);
        System.out.println(userByParams);
    }


    @Test
    public void mytest6(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userByParams = userMapper.findUserListByParams(null, null, "123456");
        for (User user :
                userByParams) {
            System.out.println(user);
        }

    }

    @Test
    public void mytest7(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("1111");
        user.setPassword("11111111111");
        user.setMoney(1111111);


        User user1 = new User();
        user1.setUsername("2222");
        user1.setPassword("22222222222");
        user1.setMoney(22222);

        User user2 = new User();
        user2.setUsername("3333");
        user2.setPassword("33333333333333");
        user2.setMoney(333333);

        User user3 = new User();
        user3.setUsername("4444");
        user3.setPassword("44444444444444444");
        user3.setMoney(4444444);

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        int i = userMapper.insertUserBatch(list);
        System.out.println(i);
    }

    @Test
    public void myTest8(){
         sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("dsafdsafasd");
        user.setPassword("333333333333333333");
        int i = mapper.insertTestSelectKey(user);
        System.out.println(user.getId());
    }

    @Test
    public void myTest9(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("iuiyut");
        user.setPassword("333333333333333333");
        int i = mapper.insertTestUseGenerateKey(user);
        System.out.println(user.getId());
    }
}
