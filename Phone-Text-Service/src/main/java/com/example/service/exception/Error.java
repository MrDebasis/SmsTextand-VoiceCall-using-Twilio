package com.example.service.exception;

import com.twilio.exception.ApiException;

public class Error extends ApiException {

    public Error(String message, Integer code, String moreInfo, Integer status, Throwable cause) {
        super(message, code, moreInfo, status, cause);
    }
}
