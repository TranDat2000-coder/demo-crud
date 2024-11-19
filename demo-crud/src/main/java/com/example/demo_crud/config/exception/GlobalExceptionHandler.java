package com.example.demo_crud.config.exception;

import com.example.demo_crud.common.ErrorCode;
import com.example.demo_crud.response.common.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleRequestException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            errors.add(error.getDefaultMessage());
        }
        return defhandler(HttpStatus.BAD_REQUEST, ErrorCode.INPUT_INVALID.getErrorCode(), errors.toString());
    }

    public ResponseEntity<Object> defhandler(HttpStatus status, String errorCode, String message) {
        return new ResponseEntity<>(ResponseData.failed(status, errorCode, message), status);
    }
}
