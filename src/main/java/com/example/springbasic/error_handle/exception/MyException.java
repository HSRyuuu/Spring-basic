package com.example.springbasic.error_handle.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;
}
