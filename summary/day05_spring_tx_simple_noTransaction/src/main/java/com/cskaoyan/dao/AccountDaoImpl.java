package com.cskaoyan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;



/* 继承JdbcDaoSupport是为了得到他的setDataSource方法，可以设置数据池*/
/* 和得到JDBCTemplate（getJdbcTemplate → springjdbc）*/
@Repository
public class AccountDaoImpl  extends JdbcDaoSupport implements AccountDao {

    /*  @Autowired实现自动注入，可以把XML配置的DataSource自动注入到形参这里 */
    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        /* setDataSource由继承的JdbcDaoSupport提供*/
        setDataSource(dataSource);
    }

    @Override
    public int findUserById(int id) {
        String sql = "select money from user_data where id =?";
        /* getJdbcTemplate由继承的JdbcDaoSupport提供*/
        Integer money = getJdbcTemplate().queryForObject(sql, int.class, id);

        return money==null?0 : money;
    }

    @Override
    public void updateMoneyByIdAndMoney(int id, int money) {
        String sql = "update user_data set money = ? where id = ?";
        getJdbcTemplate().update(sql,money,id);
    }


}
