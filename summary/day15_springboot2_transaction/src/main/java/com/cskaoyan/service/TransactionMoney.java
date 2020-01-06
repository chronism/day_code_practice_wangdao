package com.cskaoyan.service;

public interface TransactionMoney {

    public void transactionMoneyById(int from_id,int to_id,int money);


    public void transactionMoneyByName(String from_name,String to_name,int money);
}
