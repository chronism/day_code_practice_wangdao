package com.cskaoyan.service;

import com.cskaoyan.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountDao accountDao;

    @Override
    public void transMoney(int id1, int id2, int money) {
        int money1 = accountDao.findUserById(id1);
        int money2 = accountDao.findUserById(id2);
        accountDao.updateMoneyByIdAndMoney(id1,money1-money);
        int i =1/0;
        accountDao.updateMoneyByIdAndMoney(id2,money2+money);
    }
}
