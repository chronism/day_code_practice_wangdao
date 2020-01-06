package com.cskaoyan.controller;

import com.cskaoyan.bean.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class I18nController {

    @Autowired
    MessageSource messageSource;

    @RequestMapping("i18n")
    public DataVo run(String key,Locale locale/*,HttpServletRequest request*/){

        /*Locale locale = request.getLocale();*/
        //key locale
        /*Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);*/
        System.out.println(locale);
        String message = messageSource.getMessage(key, null, locale);
        DataVo dataVo = new DataVo();
        dataVo.setErrorMsg(message);
        return dataVo;
    }
    @RequestMapping("run")
    public DataVo run(String name,int number,Locale locale){

        Object[] params = {name, number};
        String message = messageSource.getMessage("weekly.run", params, locale);
        DataVo dataVo = new DataVo();
        dataVo.setErrorMsg(message);
        return dataVo;
    }
}
