package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

    static DataSource dataSource;
    /* ThreadLocal生成方法 */
    static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    /*  静态代码块是在函数编译的时候就加载 */
    static {
        Properties properties = new Properties();
        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("pro.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws Exception {

        return dataSource.getConnection();
    }

    public static Connection getTransactionConnection(Boolean autoCommit) throws Exception {
        Connection connection = threadLocal.get();
        if (!autoCommit) {
            if (connection == null) {
                    connection = getConnection();
                /*这个设完connection之后，connection实际上已经转为threalocal connection*/
                /*不要把事务开始connection.setAutocommit(false)写在这里面，因为一个事务可以写很多个sql*/
                threadLocal.set(connection);
            }
            return connection;

        } else {
                return getConnection();
        }
    }

    public static void restoreThreadCOnnection() {
        if (threadLocal.get() != null) {
            threadLocal.set(null);
        }
    }

    public static void close(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
