package com.example.orderservice.handler;

import com.example.orderservice.dto.ApiResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ApiResponseError handleRuntimeException(RuntimeException ex) {

        return new ApiResponseError(
                LocalDateTime.now(),
                503,
                "Service Unavailable",
                ex.getMessage()
        );
    }
}