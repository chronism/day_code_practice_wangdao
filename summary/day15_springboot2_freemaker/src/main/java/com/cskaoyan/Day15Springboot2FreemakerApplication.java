package com.cskaoyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan.mapper")
public class Day15Springboot2FreemakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day15Springboot2FreemakerApplication.class, args);
    }

}
