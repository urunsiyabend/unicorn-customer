package com.krontech.unicorn.customer.repositories.customers;

import com.krontech.unicorn.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.username = :username")
    Customer findByUsername(String username);

    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmail(String email);
}
