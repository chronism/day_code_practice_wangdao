package com.cskaoyan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class AccountDaoImpl  extends JdbcDaoSupport implements AccountDao {

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        setDataSource(dataSource);
        //System.out.println("我设置了JDBCTEmplate，但是没给数据库");
    }

    @Override
    public int findUser(int id) {
        String sql = "select totalMoney from user_m where id =?";
        Integer money = getJdbcTemplate().queryForObject(sql, int.class, id);

        return money==null?0 : money;
    }

    @Override
    public void updateMoney(int id, int money) {
        String sql = "update user_m set totalMoney = ? where id = ?";
        getJdbcTemplate().update(sql,money,id);
    }


}
