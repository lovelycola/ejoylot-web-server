package com.ejoylot.exception;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.exception
 * Date: 18-5-8
 * User: dennis
 */
public class BaseException extends Exception{

    private ErrorCode errorCode;

    public BaseException(){
        super();
    }
    public BaseException(ErrorCode errorCode,String message){
        super(message);
        this.errorCode=errorCode;

    }
    public BaseException(ErrorCode errorCode,String message, Throwable cause){
        super(message,cause);
        this.errorCode=errorCode;
    }
    public BaseException(ErrorCode errorCode,Throwable cause){
        super(cause);
        this.errorCode=errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
