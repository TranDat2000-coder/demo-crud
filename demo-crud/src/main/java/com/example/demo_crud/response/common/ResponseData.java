package com.example.demo_crud.response.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResponseData<T> implements Serializable {

    private int status;
    private String errorCode;
    private String message;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss",
            lenient = OptBoolean.FALSE
    )
    private Date timestamp = new Date();
    private T data;

    public ResponseData(){
    }

    public ResponseData<T> success(T data){
        return restResult(data, HttpStatus.OK.value(), null, "success");
    }

    public ResponseData<T> failed(T data, String message){

    }

    public static <T> ResponseData<T> restResult(T data, int status, String errorCode, String message){
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setStatus(status);
        responseData.setErrorCode(errorCode);
        responseData.setMessage(message);
        responseData.setData(data);
        return responseData;
    }
}
