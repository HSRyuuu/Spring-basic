package com.example.springbasic.error_handle;

import com.example.springbasic.error_handle.dto.ErrorResponse;
import com.example.springbasic.error_handle.exception.ErrorCode;
import com.example.springbasic.error_handle.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestController
public class ErrorController {


    @GetMapping("/order/{orderId}/error")
    public String throwException(@PathVariable String orderId) throws IllegalAccessException, SQLIntegrityConstraintViolationException {
        log.info("error controller");
        if("500".equals(orderId)){
            throw new IllegalAccessException("IllegalAccessException");
        }else if("1000".equals(orderId)){
            throw new MyException(ErrorCode.TOO_BIG_ID_ERROR, "1000 is too big");
        }else if("1".equals(orderId)){
            throw new MyException(ErrorCode.TOO_SMALL_ID_ERROR, "1 is too small");
        }
        if("4".equals(orderId)){
            throw new SQLIntegrityConstraintViolationException("Constraint Violation");
        }
        return "orderId: "  + orderId;
    }
    /**
     * 방법 1
     * ErrorResponse 객체 사용 , @ResponseStatus, @ExceptionHandler
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    //@ExceptionHandler(IllegalAccessException.class)
    public ErrorResponse handleIllegalAccessException1(IllegalAccessException e){
        log.error("IllegalAccessException is occurred 1", e);

        return new ErrorResponse(ErrorCode.INVALID_ACCESS, "IllegalAccessException is occurred 1");
    }


    /**
     * 방법 2
     * ResponseEntity 사용
     */
    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ErrorResponse> handleIllegalAccessException2(IllegalAccessException e){
        log.error("IllegalAccessException is occurred 2", e);

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .header("New-header", "Some value")
                .body(new ErrorResponse(ErrorCode.INVALID_ACCESS, "IllegalAccessException is occurred 2"));
    }

    /**
     * 3. 직접 만든 에러
     * 1000 : TOO_BIG  /  1 : TOO_SMALL
     */
    @ExceptionHandler(MyException.class)
    public ResponseEntity<ErrorResponse> handleMyException(MyException e){
        log.error("MyException is occurred", e);

        return ResponseEntity
                .status(HttpStatus.INSUFFICIENT_STORAGE)
                .body(new ErrorResponse(e.getErrorCode(), e.getMessage()));
    }

    /**
     * 4. 큰 범위의 에러 발생 시
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e){
        log.error("Exception is occurred", e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, "exception is occured"));
    }
}
