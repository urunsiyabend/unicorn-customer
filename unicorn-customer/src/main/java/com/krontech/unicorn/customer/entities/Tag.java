package com.krontech.unicorn.customer.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "customer_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, List<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
