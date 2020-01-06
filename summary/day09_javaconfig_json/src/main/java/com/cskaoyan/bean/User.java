package com.cskaoyan.bean;

import lombok.Data;

/**
 *
 * {
 *     "username":"heidashuai",
 *     "password":"zhenshuai",
 *     "age":30,
 *     "userDetail":{
 *         "email":"heidashuai@cskaoyan.com",
 *         "gender":"male"
 *     }
 * }
 *
 */
@Data
public class User {
    String username;
    String password;
    int age;
    UserDetail userDetail;
}
