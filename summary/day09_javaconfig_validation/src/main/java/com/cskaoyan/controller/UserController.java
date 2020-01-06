package com.cskaoyan.controller;

import com.cskaoyan.bean.DataVo;
import com.cskaoyan.bean.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {


    @RequestMapping("login")
    public DataVo login(@Valid User user, BindingResult bindingResult){
        DataVo dataVo = new DataVo();
        System.out.println("user = " + user);
        if (bindingResult.hasErrors()){
            //根据错误信息去做错误相关的业务逻辑
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            System.out.println("defaultMessage:" + defaultMessage);
            dataVo.setErrorMsg(defaultMessage);
            return dataVo;
        }
        dataVo.setData(user);
        return dataVo;
    }
}
