package com.krontech.unicorn.customer.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @ManyToMany
    @JoinTable(
            name = "customer_tags",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    public Customer() {
    }

    public Customer(String username, String name, String surname, String email, List<Tag> tags) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tags = tags;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
