package com.ejoylot.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Copyright (c) 2018 ZheJiang Ejoylot Technology Co., Ltd.  All rights reserved.
 * Project: ejoylot-web-server
 * Package: com.ejoylot.exception
 * Date: 18-5-8
 * User: dennis
 */
public class SercurityException extends UsernameNotFoundException {

    public SercurityException(String message){
        super(message);

    }
    public SercurityException(String message, Throwable cause){
        super(message,cause);
    }

}
