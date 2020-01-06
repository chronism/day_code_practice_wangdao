package com.cskaoyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:addition.properties")
@ImportResource(locations = "classpath:beans.xml")
public class Day14SpringbootBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day14SpringbootBaseApplication.class, args);
    }

}
