package com.deepexi.exception;

@BizErrorResponseStatus()
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String msg){
        super(msg);
    }
}
