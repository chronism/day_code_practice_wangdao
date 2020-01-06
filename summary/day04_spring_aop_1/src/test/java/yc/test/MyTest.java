package yc.test;

import com.cskaoyan.dao.impl.TargetObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class MyTest {
    @Autowired
    TargetObject targetObject;

    @Autowired
    @Qualifier(value = "ttt")
    TargetObject ttt;

    @Test
    public void myTest(){
        ttt.queryUser(1);
    }


    @Test
    public void myTest3(){
        targetObject.queryUser(1);
    }
}
