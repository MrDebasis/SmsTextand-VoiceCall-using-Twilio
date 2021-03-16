package com.example.service.exception;

public class ExceptionForRequestTimeOut extends Error {
    public ExceptionForRequestTimeOut(String message, Integer code, String moreInfo, Integer status, Throwable cause) {
        super(message, code, moreInfo, status, cause);
    }
}
