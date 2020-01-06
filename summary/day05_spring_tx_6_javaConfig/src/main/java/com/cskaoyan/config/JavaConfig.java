package com.cskaoyan.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.cskaoyan")
@PropertySource("classpath:druid.properties")
@EnableTransactionManagement
public class JavaConfig {

    @Value("${driveClassName}")
    String driverClassName;
    @Value("${url}")
    String url;
    @Value("${userppp}")
    String userppp;
    @Value("${password}")
    String password;

    @Bean
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userppp);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

//     @Bean
//    public DataSource getDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("root");
//        return druidDataSource;
//    }


    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public TransactionTemplate getTransactionTemplate(DataSourceTransactionManager dataSourceTransactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(dataSourceTransactionManager);
        return transactionTemplate;
    }
}
