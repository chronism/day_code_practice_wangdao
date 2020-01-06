package com.cskaoyan.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "user")
@Component
public class User {
    Map<String,String> mapper;
    Map<String,String> mapper1;
    Map<String,String> mapper2;

    List<String> stringList1;

    List<String> stringList2;
    List<String> stringList3;
}
