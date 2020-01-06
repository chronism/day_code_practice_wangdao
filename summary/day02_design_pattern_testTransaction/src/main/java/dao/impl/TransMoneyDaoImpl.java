package dao.impl;

import dao.TransMoneyDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import utils.DBUtils;
import javax.sql.DataSource;
import java.util.Map;

public class TransMoneyDaoImpl implements TransMoneyDao {

    User user = null;
    DataSource dataSource;

    {
        try {
            dataSource = DBUtils.getDataSource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    QueryRunner queryRunner = new QueryRunner(dataSource);



    @Override
    public User findUserByName(String userName) throws Exception {
        String sql="select money from user_data where username = ?";
        /*  queryRunner的使用  */
        Map<String, Object> query = queryRunner.query(sql, new MapHandler(),userName);
        Integer money= (Integer) query.get("money");
        if(money!=null){
            user =new User();
            user.setUserName(userName);
            user.setMoney(money);
            return user;
        }
        return null;
    }

    @Override
    public Boolean updateUserByNameAndMoney(String username, int money) throws Exception {
        String sql="update user_data set money = ?  where username = ?";
        int update = queryRunner.update(DBUtils.getTransactionConnection(false),sql, money, username);
        if(update==0){
            return false;
        }else {
            return true;
        }
    }
}
