package com.example.service.exception;

public class ExceptionForMethodNotAllowed extends Error{
    public ExceptionForMethodNotAllowed(String message, Integer code, String moreInfo, Integer status, Throwable cause) {
        super(message, code, moreInfo, status, cause);
    }
}
