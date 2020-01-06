package test;

import dao.TransMoneyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.TransMoneyService;
import service.impl.TransMoneyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class MyTest {

    @Autowired
    TransMoneyService transMoneyService;


    @Test
    public void myTest() {
        transMoneyService.transMoney("lisi", "zhangsan", 500);
    }
}
