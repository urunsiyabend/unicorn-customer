package com.krontech.unicorn.customer.controllers.customers.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private int id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private List<String> tags;
}
