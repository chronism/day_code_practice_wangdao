package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Component
public class DruidUtils {

    private static DataSource datasource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(inputStream);
            datasource = new DruidDataSourceFactory().createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DataSource getDatasource() {
        return datasource;
    }

    public static void releaseResource(Connection connection, Statement statement, ResultSet resultSet)  {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection(boolean autoCommit) throws SQLException {
        if (!autoCommit) {
            Connection connection = threadLocal.get();
            if (connection == null) {
                connection = getConnection();
                /* 相当于把当前的connection设到threadlocal里面了，以后再从threadlocal里面取，都是同一个*/
                threadLocal.set(connection);
            }
            return connection;
        }

        return getConnection();

    }

    public static void restoreConnection() {
        threadLocal.set(null);
    }

}
