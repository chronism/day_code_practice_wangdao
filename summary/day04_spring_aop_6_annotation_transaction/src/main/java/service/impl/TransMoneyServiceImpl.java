package service.impl;

import dao.TransMoneyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TransMoneyService;

@Service
public class TransMoneyServiceImpl implements TransMoneyService {

    @Autowired
    TransMoneyDao transMoneyDao;

    @Override
    public void transMoney(String name1, String name2, int money) {
        int money1 = transMoneyDao.findUser(name1);
        int money2 = transMoneyDao.findUser(name2);
        transMoneyDao.updateMoney(name1, money1 - money);
        int i=1/0;
        transMoneyDao.updateMoney(name2, money2 + money);
    }


}
