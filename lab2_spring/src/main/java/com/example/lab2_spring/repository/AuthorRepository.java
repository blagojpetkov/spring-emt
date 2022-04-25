package com.example.lab2_spring.repository;

import com.example.lab2_spring.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
