package com.ejoylot.exception;

import org.springframework.http.HttpStatus;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.exception
 * Date: 18-5-8
 * User: dennis
 */
public enum ErrorCode {

    DEFAULT_ERROR("DEFAULT_ERROR", "ERR_0000", HttpStatus.BAD_REQUEST),
    RUNTIME_ERROR("RUNTIME_ERROR", "ERR_0001",HttpStatus.BAD_REQUEST),
    VALIDATE_ERROR("VALIDATE_ERROR", "ERR_0002",HttpStatus.BAD_REQUEST),
    UNAUTHORIZED_ERROR("UNAUTHORIZED_ERROR", "ERR_0003",HttpStatus.UNAUTHORIZED),
    FEIGN_ERROR("FEIGN_ERROR", "ERR_0003",null);

    private String errType;
    private String customErrorCode;
    private HttpStatus httpStatus;

    ErrorCode(String errType, String customErrorCode, HttpStatus httpStatus) {
        this.errType = errType;
        this.customErrorCode = customErrorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    public String getCustomErrorCode() {
        return customErrorCode;
    }

    public void setCustomErrorCode(String customErrorCode) {
        this.customErrorCode = customErrorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
