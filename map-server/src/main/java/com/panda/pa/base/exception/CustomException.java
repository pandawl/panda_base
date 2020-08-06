package com.panda.pa.base.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * 类功能简述：系统内部异常
 * @author wl
 */
@Slf4j
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 3079772281646250192L;

    public CustomException(Exception e) {
        super(e.getMessage());
        this.setStackTrace(e.getStackTrace());
    }


    public CustomException(String message) {
        super( message );
    }

    public CustomException(String message, Exception e) {
        super( message);
    }

    public CustomException(String message, String type) {
        super( type + ": " + message );
    }


}
