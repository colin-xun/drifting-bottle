package com.moudao.exception;

/**
 * 自定义异常
 */
public class CustomerException extends Exception{
    private String message;//异常信息  
    public CustomerException(String message){  
        this.message=message;  
    }  
    public String getMessage() {  
        return message;  
    }  
    public void setMessage(String message) {  
        this.message = message;
    }
}