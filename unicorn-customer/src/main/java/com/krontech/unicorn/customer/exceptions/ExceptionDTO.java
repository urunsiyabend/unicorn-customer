package com.krontech.unicorn.customer.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDTO {
    private final int statusCode;
    private final String message;
    private final String details;
}
