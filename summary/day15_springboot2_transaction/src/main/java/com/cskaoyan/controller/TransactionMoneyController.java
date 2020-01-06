package com.cskaoyan.controller;


import com.cskaoyan.service.TransactionMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransactionMoneyController {

    @Autowired
    TransactionMoney transactionMoney;


    @RequestMapping("/user/transaction/id")
    public String transactionById(int from_id, int to_id, int money) {
        transactionMoney.transactionMoneyById(from_id, to_id, money);
        return "success";
    }

    @RequestMapping("/user/transaction/username")
    public String transactionByName(String from_name,String to_name,int money){
        transactionMoney.transactionMoneyByName(from_name,to_name,money);
        return "success";
    }

    @RequestMapping("/user/transaction/login")
    public String login(){
        return "login";
    }
}
