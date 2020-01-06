package test;

import domain.User;
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


    InputStream resourceAsStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void testDemo() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("mybaties.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @After
    public void myTestDemo1() throws IOException {
        if(sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
        }
       if(resourceAsStream!=null){
           resourceAsStream.close();
       }
    }

    @Test
    public void mytestDemo2(){
        sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        int insert = sqlSession.insert("UserMapper.insertUser", user);
        System.out.println(insert);
    }

    @Test
    public void mytestDemo3(){
        sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        User user1 = (User) sqlSession.selectOne("UserMapper.selectUserByNameAndPassword", user);
        System.out.println(user1);
    }
}
