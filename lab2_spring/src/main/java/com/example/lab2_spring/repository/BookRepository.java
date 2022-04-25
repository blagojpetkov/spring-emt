package com.example.lab2_spring.repository;

import com.example.lab2_spring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
