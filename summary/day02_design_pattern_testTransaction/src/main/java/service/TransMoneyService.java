package service;

import domain.User;

public interface TransMoneyService {
    void transMoney(String user1, String  user2, int money) throws Exception;
}
