package com.example.demo_crud.response.common;

import com.example.demo_crud.common.ErrorCode;

public class BusinessException extends RuntimeException{

    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode.getErrorCode();
    }

    public String getMessage() {
        return this.errorCode.getMessage();
    }
}
