package com.cskaoyan.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
/* 主要是访问前缀带有user的属性配置*/
@ConfigurationProperties(prefix = "user")
/*要注册组件*/
@Component
public class User {
    Map<String,String> mapper;

    List<String> stringList;
}
