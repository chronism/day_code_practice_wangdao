package com.cskaoyan.dao.impl;


import org.springframework.stereotype.Repository;

@Repository
public class TargetObject  {

    public void queryUser(int i){
         System.out.println("我是Dao:"+i);
    }
}
