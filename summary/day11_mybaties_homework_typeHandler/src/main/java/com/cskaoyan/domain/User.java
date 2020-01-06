package com.cskaoyan.domain;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    UserDetail userDetail;
}
