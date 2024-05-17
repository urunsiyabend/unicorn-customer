package com.krontech.unicorn.customer.controllers.customers.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCreateRequest {
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Surname is required")
    private String surname;

    @NotBlank(message = "Email is required")
    @Pattern(regexp=".+@.+\\..+", message = "Email format is invalid, please provide a valid email")
    private String email;

    private List<String> tags;
}
