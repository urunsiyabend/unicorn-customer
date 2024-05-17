package com.krontech.unicorn.customer.services.customers;

import com.krontech.unicorn.customer.exceptions.ServiceException;

import java.util.List;

public class InvalidTagsException extends ServiceException {
    public InvalidTagsException(List<String> invalidTags) {
        super("Invalid tags", "The following tags are invalid: " + invalidTags);
    }
}
