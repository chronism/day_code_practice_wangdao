package dao;

import domain.User;

public interface TransMoneyDao {
    User findUserByName(String userName) throws Exception;
    Boolean updateUserByNameAndMoney(String username,int money) throws Exception;
}
