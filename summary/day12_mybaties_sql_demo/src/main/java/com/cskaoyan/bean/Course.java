package com.cskaoyan.bean;

import lombok.Data;

import java.util.List;

@Data
public class Course {

    private Integer id;

    private String courseName;

    private List<User> userList;
}
