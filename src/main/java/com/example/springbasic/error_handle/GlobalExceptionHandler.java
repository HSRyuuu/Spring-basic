package com.example.springbasic.error_handle;

import com.example.springbasic.error_handle.dto.ErrorResponse;
import com.example.springbasic.error_handle.exception.ErrorCode;
import com.example.springbasic.error_handle.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 어플리케이션의 전반적인(전역적) 예외처리
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * IllegalAccessException handler
     */
    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ErrorResponse> handleIllegalAccessException2(IllegalAccessException e){
        log.error("IllegalAccessException is occurred 2", e);

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .header("New-header", "Some value")
                .body(new ErrorResponse(ErrorCode.INVALID_ACCESS, "IllegalAccessException is occurred 2"));
    }

    /**
     * 직접 만든 에러 MyException handler
     * 1000 : TOO_BIG  /  1 : TOO_SMALL
     */
    @ExceptionHandler(MyException.class)
    public ResponseEntity<ErrorResponse> handleMyException(MyException e){
        log.error("MyException is occurred", e);

        return ResponseEntity
                .status(HttpStatus.INSUFFICIENT_STORAGE)
                .body(new ErrorResponse(e.getErrorCode(), e.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e){
        log.error("Exception is occurred", e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, "exception is occured"));
    }
}
