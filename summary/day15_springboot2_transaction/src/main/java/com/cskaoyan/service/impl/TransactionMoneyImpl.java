package com.cskaoyan.service.impl;

import com.cskaoyan.mapper.UseraMapper;
import com.cskaoyan.service.TransactionMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class TransactionMoneyImpl implements TransactionMoney {
    @Autowired
    UseraMapper useraMapper;


    @Override
    public void transactionMoneyById(int from_id, int to_id, int money) {
        Integer money1 = Integer.parseInt(useraMapper.selectUserById(from_id).getMoney());
        Integer money2 = Integer.parseInt(useraMapper.selectUserById(to_id).getMoney());
        useraMapper.upDateMoneyById(from_id, money1 - money);
        int i=1/0;
        useraMapper.upDateMoneyById(to_id, money2 + money);
    }


    @Override
    public void transactionMoneyByName(String from_name, String to_name, int money) {
        Integer money1 = Integer.parseInt(useraMapper.selectUserByName(from_name).getMoney());
        Integer money2 = Integer.parseInt(useraMapper.selectUserByName(to_name).getMoney());
        useraMapper.upDateMoneyByUsername(from_name, money1 - money);
        useraMapper.upDateMoneyByUsername(to_name, money2 + money);
    }
}
