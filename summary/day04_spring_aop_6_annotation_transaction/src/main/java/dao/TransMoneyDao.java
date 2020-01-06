package dao;



public interface TransMoneyDao {

    int findUser(String name) ;
    void updateMoney(String name, int money);
}
