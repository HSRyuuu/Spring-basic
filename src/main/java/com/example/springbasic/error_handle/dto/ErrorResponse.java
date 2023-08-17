package com.example.springbasic.error_handle.dto;


import com.example.springbasic.error_handle.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private ErrorCode errorCode;
    private String message;
}
