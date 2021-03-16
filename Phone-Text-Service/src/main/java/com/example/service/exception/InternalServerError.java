package com.example.service.exception;

public class InternalServerError extends Error{
    public InternalServerError(String message, Integer code, String moreInfo, Integer status, Throwable cause) {
        super(message, code, moreInfo, status, cause);
    }
}
