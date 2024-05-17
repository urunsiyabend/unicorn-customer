package com.krontech.unicorn.customer.config;

import com.krontech.unicorn.customer.exceptions.ExceptionDTO;
import com.krontech.unicorn.customer.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerConfig {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(ServiceException exception) {
        return ResponseEntity
                .status(HttpStatus.valueOf(exception.getStatusCode()))
                .body(
                        ExceptionDTO.builder()
                                .statusCode(exception.getStatusCode())
                                .message(exception.getMessage())
                                .details(exception.getDetails())
                                .build()
                );
    }
}