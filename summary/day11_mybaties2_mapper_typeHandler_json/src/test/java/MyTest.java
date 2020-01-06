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
        if(inputStream!=null){
            inputStream.close();;
        }
        if(sqlSession!=null){
            /* 一定要提交事务 */
            sqlSession.commit();;
            sqlSession.close();
        }
    }

    @Test
    public void myTest3(){
        /* sqlSessionFactory.openSession()事务开启 */
         sqlSession = sqlSessionFactory.openSession();
        Object o = this.sqlSession.selectOne("org.mybatis.example.BlogMapper.selectUserNameById", 1);
        System.out.println(o);
    }

    @Test
    public void myTest4(){
        /* sqlSessionFactory.openSession()事务开启 */
        sqlSession = sqlSessionFactory.openSession();
        Object o = this.sqlSession.selectOne("org.mybatis.example.BlogMapper.selectUserById", 1);
        System.out.println(o);
    }
}
