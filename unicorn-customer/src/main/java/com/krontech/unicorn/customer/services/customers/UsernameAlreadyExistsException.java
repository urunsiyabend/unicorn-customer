package com.krontech.unicorn.customer.services.customers;

import com.krontech.unicorn.customer.exceptions.ServiceException;

public class UsernameAlreadyExistsException extends ServiceException {
    public UsernameAlreadyExistsException(String username) {
        super("Username already exists", "The username " + username + " already exists");
    }
}
