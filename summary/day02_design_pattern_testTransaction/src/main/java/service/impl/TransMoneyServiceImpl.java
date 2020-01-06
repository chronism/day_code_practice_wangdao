package service.impl;

import dao.TransMoneyDao;
import dao.impl.TransMoneyDaoImpl;
import domain.User;
import service.TransMoneyService;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransMoneyServiceImpl implements TransMoneyService {

    TransMoneyDao proxyTrans = new TransMoneyDaoImpl();

    @Override
    public void transMoney(String usernameFrom, String usernameTo, int money) throws SQLException {
        /*
         *
         * 异常要一个个往上抛，一直抛到这里，统一做处理
         *
         * */
        Connection transactionConnection = null;
        try {
            transactionConnection = DBUtils.getTransactionConnection(false);
            transactionConnection.setAutoCommit(false);
            User user1 = proxyTrans.findUserByName(usernameFrom);
            User user2 = proxyTrans.findUserByName(usernameTo);
            if (user1 != null && user1.getMoney() > money && user2 != null) {
                proxyTrans.updateUserByNameAndMoney(user1.getUserName(), user1.getMoney() - money);
                proxyTrans.updateUserByNameAndMoney(user2.getUserName(), user2.getMoney() + money);
            }

            int i= 1/0;
            transactionConnection.commit();
        } catch (Exception e) {
            transactionConnection.rollback();
            e.printStackTrace();
        } finally {
            transactionConnection.close();
            DBUtils.restoreThreadCOnnection();
        }


    }
}
