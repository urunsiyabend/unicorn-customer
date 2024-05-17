package com.krontech.unicorn.customer.exceptions;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private final int statusCode = 400;
    private final String message;
    private final String details;

    public ServiceException(String message, String details) {
        super(message);
        this.message = message;
        this.details = details;
    }
}
