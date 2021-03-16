package com.example.service.exception;

public class ExceptionForUnauthorized extends Error{
    public ExceptionForUnauthorized(String message, Integer code, String moreInfo, Integer status, Throwable cause) {
        super(message, code, moreInfo, status, cause);
    }
}
