package com.cskaoyan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18nComponent {

    @Autowired
    MessageSource messageSource;

    public String getMessage(String key, Locale locale){
        return messageSource.getMessage(key,null,locale);
    }
    /*public String getMessage(String key, String locale){
        return messageSource.getMessage(key,null,locale);
    }*/
}
