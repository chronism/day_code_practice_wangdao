import domain.HouseOwner;
import domain.RentHouse;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestMethod {
    @Test
    public void myTets(){
        HouseOwner owner = new HouseOwner();
        /*newProxyInstance 第一个参数是类加载器，第二个是接口，第三个是匿名内部类*/
       RentHouse rentHouse= (RentHouse) Proxy.newProxyInstance(owner.getClass().getClassLoader(), owner.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*invoke的第一个参数不重要，第三个是参数*/
                if("rentHouse".equals(method.getName())){
                    args[0] = (int)args[0] - 1000;
                }
                long l = System.currentTimeMillis();
                System.out.println("开始计时"+l+"ms");

                Object invoke = method.invoke(owner, args);/* owner是需要代理的对象，不能是自身，否则会递归*/
                long l1 = System.currentTimeMillis();
                System.out.println("结束计时"+l1+"ms");
                long ll= (l1-l);
                System.out.println("总共用时"+ll+"ms");
                return invoke;
            }
        });
        rentHouse.rentHouse(3000);
        rentHouse.rentHouse(4000);
        owner.rentHouse(3000);
    }
    @Test
    public void myTest2() throws Exception {
        /* 类方法 */
        Method rentHouse = RentHouse.class.getMethod("rentHouse", int.class);
        /*  代理new HouseOwner这个方法*/
        Object invoke = rentHouse.invoke(new HouseOwner(), 4000);
    }
}
