package com.cskaoyan.bean;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer money;
    /*  一对一 */
    private UserDetail userDetail;

    /*  一对多 */
    private List<Order> orderList;

    private List<Course> courseList;
}
