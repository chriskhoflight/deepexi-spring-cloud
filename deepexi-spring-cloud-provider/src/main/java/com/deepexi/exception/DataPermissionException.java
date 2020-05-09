package com.deepexi.exception;


@BizErrorResponseStatus
public class DataPermissionException extends RuntimeException {
    public DataPermissionException(String msg){
        super(msg);
    }
}
