package com.example.service.exception;

public class ExceptionForFrobidden extends Error{
    public ExceptionForFrobidden(String message, Integer code, String moreInfo, Integer status, Throwable cause) {
        super(message, code, moreInfo, status, cause);
    }
}
