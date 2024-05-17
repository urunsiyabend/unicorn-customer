package com.krontech.unicorn.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// jmeter -n -t .\jmeter_config\performance_test.jmx -l .\reports\results-14-05-2024.csv -e -o .\reports\jmeter\web

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
