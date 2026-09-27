package com.ding.xxx_crud.exception;

import com.ding.xxx_crud.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFound(NotFoundException ex){
        ErrorResponseDto dto = new ErrorResponseDto( 404, ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponseDto> handleBadRequest(Exception ex) {
        ErrorResponseDto error = new ErrorResponseDto(400, "❌ Data format error", null);
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler({MyException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponseDto> handleMyException(MyException ex){
        ErrorResponseDto dto = new ErrorResponseDto(ex.getStatus(), ex.getMessage(), null);
        return ResponseEntity.status(ex.getStatus()).body(dto);
    }
    // 可選：加上通用例外處理
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception ex) {
        ex.printStackTrace();
        ErrorResponseDto dto = new ErrorResponseDto(
                500,
                "(該死)未預計的錯誤: " + ex.getMessage(),
                null
        );
        return ResponseEntity.status(500).body(dto);
    }

}
