package com.deepexi.exception;

@BizErrorResponseStatus
public class DataRepetitionException extends RuntimeException {
    public DataRepetitionException(String msg){
        super(msg);
    }
}
