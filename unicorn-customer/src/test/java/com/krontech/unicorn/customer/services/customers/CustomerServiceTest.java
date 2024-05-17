package com.krontech.unicorn.customer.services.customers;

import com.krontech.unicorn.customer.dtos.customers.CustomerDTO;
import com.krontech.unicorn.customer.entities.Customer;
import com.krontech.unicorn.customer.entities.Tag;
import com.krontech.unicorn.customer.repositories.customers.ICustomerRepository;
import com.krontech.unicorn.customer.repositories.customers.ITagRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest(
        properties = {
                "spring.datasource.url=jdbc:h2:mem:testdb",
                "spring.jpa.hibernate.ddl-auto=create-drop"
        }
)
class CustomerServiceTest {
//    private final CustomerService customerService;
//    private final ICustomerRepository customerRepository;
//    private final ITagRepository tagRepository;
//
//    @Autowired
//    public CustomerServiceTest(CustomerService customerService, ICustomerRepository customerRepository, ITagRepository tagRepository) {
//        this.customerService = customerService;
//        this.customerRepository = customerRepository;
//        this.tagRepository = tagRepository;
//    }
//
//    @BeforeEach
//    void setUp() {
//        tagRepository.saveAll(List.of(
//                new Tag("african"),
//                new Tag("american"),
//                new Tag("asian")
//        ));
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void addCustomer() {
//        CustomerDTO customerDTO = CustomerDTO.builder()
//                .username("username")
//                .name("name")
//                .surname("surname")
//                .email("email")
//                .tags(List.of("australian"))
//                .build();
//
//        int count = customerRepository.findAll().size();
//
//        CustomerDTO finalCustomerDTO = customerDTO;
//        assertThrows(InvalidTagsException.class, () -> customerService.add(finalCustomerDTO));
//
//        assertEquals(count, customerRepository.findAll().size());
//
//        customerDTO = CustomerDTO.builder()
//                .username("username")
//                .name("name")
//                .surname("surname")
//                .email("email")
//                .tags(List.of("african", "american", "asian"))
//                .build();
//
//        customerService.add(customerDTO);
//
//        assertEquals(count + 1, customerRepository.findAll().size());
//
//        Customer customer = customerRepository.findByUsername("username");
//
//        assertEquals("username", customer.getUsername());
//        assertEquals("name", customer.getName());
//        assertEquals("surname", customer.getSurname());
//        assertEquals("email", customer.getEmail());
//        assertEquals(3, customer.getTags().size());
//
//        CustomerDTO finalCustomerDTO1 = customerDTO;
//        assertThrows(UsernameAlreadyExistsException.class, () -> customerService.add(finalCustomerDTO1));
//
//        assertThrows(EmailAlreadyExistsException.class, () -> customerService.add(finalCustomerDTO1));
//    }
}