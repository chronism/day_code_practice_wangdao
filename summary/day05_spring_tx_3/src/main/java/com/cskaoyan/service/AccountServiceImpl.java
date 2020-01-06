package com.cskaoyan.service;

import com.cskaoyan.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountDao accountDao;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    public void transMoney(int id1, int id2, int money) {
        transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus transactionStatus) {
                int money1 = accountDao.findUser(id1);
                int money2 = accountDao.findUser(id2);
                accountDao.updateMoney(id1,money1-money);
                accountDao.updateMoney(id2,money2+money);
                return null;
            }
        });

    }
}
