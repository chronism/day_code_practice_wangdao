package com.cskaoyan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public interface AccountDao  {


    public void setJdbcTemplate(DataSource dataSource);

    public int findUserById(int id) ;

    public void updateMoneyByIdAndMoney(int id, int money) ;


}
