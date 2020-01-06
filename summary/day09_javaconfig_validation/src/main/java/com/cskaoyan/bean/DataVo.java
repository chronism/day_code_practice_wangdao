package com.cskaoyan.bean;

import lombok.Data;

@Data
public class DataVo<T> {
    String errorNo; //错误码
    String errorMsg; //错误信息
    T data; //携带的数据
}
