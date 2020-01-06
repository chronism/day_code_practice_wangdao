package com.cskaoyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.cskaoyan.web")
public class Day15Springboot2FilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day15Springboot2FilterApplication.class, args);
    }

}
