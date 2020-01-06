package com.cskaoyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.cskaoyan.mapper")
@EnableTransactionManagement
public class Day15Springboot2TransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day15Springboot2TransactionApplication.class, args);
    }

}
