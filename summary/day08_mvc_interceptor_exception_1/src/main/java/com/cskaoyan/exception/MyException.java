package com.cskaoyan.exception;

import org.springframework.stereotype.Component;


/**/
public class MyException extends Exception {

    private String myExceptionMessage;

    public MyException(String myExceptionMessage) {
        this.myExceptionMessage = myExceptionMessage;
    }

    public String getMyExceptionMessage() {
        return myExceptionMessage;
    }

   /* public void setMyExceptionMessage(String myExceptionMessage) {
        this.myExceptionMessage = myExceptionMessage;
    }*/


}
