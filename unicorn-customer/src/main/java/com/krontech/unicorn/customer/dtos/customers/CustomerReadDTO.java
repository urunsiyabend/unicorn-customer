package com.krontech.unicorn.customer.dtos.customers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerReadDTO {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
    private List<String> tags;
}
