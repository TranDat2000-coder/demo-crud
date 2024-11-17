package com.example.demo_crud.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {

    INPUT_INVALID("203", "Input invalid");

    private String errorCode;

    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
