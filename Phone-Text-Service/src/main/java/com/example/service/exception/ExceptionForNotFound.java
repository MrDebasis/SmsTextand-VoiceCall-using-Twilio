package com.example.service.exception;

public class ExceptionForNotFound extends Error{
    public ExceptionForNotFound(String message, Integer code, String moreInfo, Integer status, Throwable cause) {
        super(message, code, moreInfo, status, cause);
    }
}
