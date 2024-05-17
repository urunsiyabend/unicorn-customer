package com.krontech.unicorn.customer.services.customers;

import com.krontech.unicorn.customer.dtos.customers.CustomerDTO;
import com.krontech.unicorn.customer.dtos.customers.CustomerReadDTO;
import com.krontech.unicorn.customer.entities.Customer;
import com.krontech.unicorn.customer.entities.Tag;
import com.krontech.unicorn.customer.repositories.customers.ICustomerRepository;
import com.krontech.unicorn.customer.repositories.customers.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CustomerService {
    private ICustomerRepository customerRepository;
    private ITagRepository tagRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository, ITagRepository tagRepository) {
        this.customerRepository = customerRepository;
        this.tagRepository = tagRepository;
    }

    public CustomerReadDTO add(CustomerDTO customerDTO) {
        List<Tag> tagList = tagRepository.getIntersection(customerDTO.getTags());


        if (tagList.size() != customerDTO.getTags().size()) {
            List<String> invalidTags = customerDTO.getTags().stream()
                    .filter(tag -> tagList.stream().noneMatch(t -> t.getName().equals(tag)))
                    .toList();

            throw new InvalidTagsException(invalidTags);
        }

        Customer checkUsername = customerRepository.findByUsername(customerDTO.getUsername());

        if (checkUsername != null) {
            throw new UsernameAlreadyExistsException(customerDTO.getUsername());
        }

        Customer checkEmail = customerRepository.findByEmail(customerDTO.getEmail());

        if (checkEmail != null) {
            throw new EmailAlreadyExistsException(customerDTO.getEmail());
        }

        List<Tag> tags = new ArrayList<>(tagList);

        Customer customer = new Customer(
                customerDTO.getUsername(),
                customerDTO.getName(),
                customerDTO.getSurname(),
                customerDTO.getEmail(),
                tags
        );

        customerRepository.save(customer);

        customer = customerRepository.findByUsername(customerDTO.getUsername());

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        return CustomerReadDTO.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .tags(customer.getTags().stream().map(Tag::getName).toList())
                .build();
    }

    public List<CustomerReadDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(customer -> CustomerReadDTO.builder()
                        .id(customer.getId())
                        .username(customer.getUsername())
                        .name(customer.getName())
                        .surname(customer.getSurname())
                        .email(customer.getEmail())
                        .tags(customer.getTags().stream().map(Tag::getName).toList())
                        .build())
                .toList();
    }
}
