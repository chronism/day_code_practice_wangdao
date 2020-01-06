package dao.impl;

import dao.TransMoneyDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.springframework.stereotype.Repository;
import utils.DruidUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class TransMoneyDaoImpl implements TransMoneyDao {
    DataSource datasource = DruidUtils.getDatasource();

    @Override
    public int findUser(String name)  {
        String sql="select money from user_data where username= ?";
        QueryRunner queryRunner= new QueryRunner(datasource);
        Map<String, Object> objectMap = null;
        try {
            objectMap = queryRunner.query(sql, new MapHandler(), name);
        } catch (SQLException e) {
            e.getMessage();
        }

        Object money = objectMap.get("money");
            return  money == null?0:(int)money;
    }

    @Override
    public void updateMoney(String name, int money) {
        String sql="update user_data set money= ? where username= ?";
        QueryRunner queryRunner= new QueryRunner();
        try {
            queryRunner.update(DruidUtils.getConnection(false),sql,money,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
