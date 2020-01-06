package com.cskaoyan.dao;

public interface AccountDao {

    int findUser(int id);

    void updateMoney(int id, int money);
}
