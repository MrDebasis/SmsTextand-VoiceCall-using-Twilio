package com.example.service.exception;

public class ExceptionForBadRequest extends Error{
    public ExceptionForBadRequest(String message, Integer code, String moreInfo, Integer status, Throwable cause) {
        super(message, code, moreInfo, status, cause);
    }
}
