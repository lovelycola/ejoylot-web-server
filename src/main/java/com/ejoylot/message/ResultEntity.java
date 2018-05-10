package com.ejoylot.message;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-api-server
 * Package: com.ejoylot.message
 * Date: 18-5-5
 * User: dennis
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultEntity<T> implements java.io.Serializable {
    private boolean success = true;
    private String message;
    private T entity;

    public ResultEntity(boolean success, String message, T entity) {
        this.success = success;
        this.message = message;
        this.entity = entity;
    }

    public static <T> ResultEntity success(T entity) {
        return new ResultEntity(true, null, entity);
    }

    public static <T> ResultEntity fail(String message, T entity) {
        return new ResultEntity(false, message, entity);
    }

    public static <T> ResultEntity fail(String message) {
        return fail(message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}