import dao.impl.TransMoneyDaoImpl;
import domain.User;
import org.junit.Test;
import service.TransMoneyService;
import service.impl.TransMoneyServiceImpl;
import utils.DBUtils;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class testTransMoney {
    @Test
    public void myTest() throws Exception {

        TransMoneyService transMoneyService = new TransMoneyServiceImpl();
        transMoneyService.transMoney("zhangsan","lisi",500);

    }

   /* @Test
    public void myTest2() throws Exception {
        TransMoneyService service = new TransMoneyServiceImpl();

        DataSource ds = DBUtils.getDataSource();
        ThreadLocal<Connection> threadLocal = DBUtils.getThreadLocal();
        threadLocal.set(ds.getConnection());
        Connection connection = threadLocal.get();
        TransMoneyService proService = (TransMoneyService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                connection.setAutoCommit(false);
                try {
                    Object invoke = method.invoke(service, args);
                    connection.commit();
                    return invoke;
                }catch (Exception e){
                    connection.rollback();
                }
                return null;
            }
        });
        proService.transMoney("zhaoliu","tianqi1",500);
    }*/
}
