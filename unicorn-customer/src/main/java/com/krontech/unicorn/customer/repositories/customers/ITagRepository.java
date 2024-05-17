package com.krontech.unicorn.customer.repositories.customers;

import com.krontech.unicorn.customer.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITagRepository extends JpaRepository<Tag, Integer> {
    @Query("SELECT t FROM Tag t WHERE t.name IN :tags")
    List<Tag> getIntersection(List<String> tags);
}
