package com.cskaoyan.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {
    /*
    * username长度6-8
    * */
    @Size(min = 6,max = 8,message = "{error.user.username}")
    @NotNull
    String username;
    /*
    * password 6
    * */
    @Size(min = 6,message = "{error.user.password}")
    String password;
}
