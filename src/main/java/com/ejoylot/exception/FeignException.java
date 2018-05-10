package com.ejoylot.exception;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.exception
 * Date: 18-5-9
 * User: dennis
 */
public class FeignException extends BaseException {


    public FeignException(int status, Throwable cause, String message) {
        super(ErrorCode.FEIGN_ERROR, message,cause);
    }

    public FeignException(int status, String message) {
        super(ErrorCode.FEIGN_ERROR, message);
    }
}
