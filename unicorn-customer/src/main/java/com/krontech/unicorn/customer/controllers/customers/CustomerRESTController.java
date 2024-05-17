package com.krontech.unicorn.customer.controllers.customers;

import com.krontech.unicorn.customer.controllers.customers.requests.CustomerCreateRequest;
import com.krontech.unicorn.customer.controllers.customers.responses.CustomerResponse;
import com.krontech.unicorn.customer.dtos.customers.CustomerDTO;
import com.krontech.unicorn.customer.dtos.customers.CustomerReadDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.krontech.unicorn.customer.services.customers.CustomerService;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
public class CustomerRESTController {
    private final CustomerService customerService;

    @Autowired
    public CustomerRESTController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("customer/add")
    @Operation(summary = "Create a new customer", description = "Create a new customer")
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerCreateRequest requestBody) {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .username(requestBody.getUsername())
                .name(requestBody.getName())
                .surname(requestBody.getSurname())
                .email(requestBody.getEmail())
                .tags(requestBody.getTags())
                .build();

        CustomerReadDTO customerReadDTO = customerService.add(customerDTO);

        return ResponseEntity.ok(CustomerResponse.builder()
                .id(customerReadDTO.getId())
                .name(customerReadDTO.getName())
                .surname(customerReadDTO.getSurname())
                .email(customerReadDTO.getEmail())
                .username(customerReadDTO.getUsername())
                .tags(customerReadDTO.getTags())
                .build());
    }

    @GetMapping("customer/all")
    @Operation(summary = "Get all customers", description = "Get all customers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        Collection<CustomerReadDTO> customers = customerService.getAllCustomers();

        List<CustomerResponse> customerResponses = customers.stream()
                .map(customer -> CustomerResponse.builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .surname(customer.getSurname())
                        .email(customer.getEmail())
                        .username(customer.getUsername())
                        .tags(customer.getTags())
                        .build())
                .toList();

        return ResponseEntity.ok(List.copyOf(customerResponses));
    }
}
