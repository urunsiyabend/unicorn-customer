package com.krontech.unicorn.customer.services.customers;

import com.krontech.unicorn.customer.exceptions.ServiceException;

public class EmailAlreadyExistsException extends ServiceException {
    public EmailAlreadyExistsException(String email) {
        super("Email already exists", "The email " + email + " already exists");
    }
}
