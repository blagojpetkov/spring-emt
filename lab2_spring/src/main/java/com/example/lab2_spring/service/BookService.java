package com.example.lab2_spring.service;

import com.example.lab2_spring.model.Author;
import com.example.lab2_spring.model.Book;
import com.example.lab2_spring.model.Category;
import com.example.lab2_spring.model.DTO.BookDto;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> markBook(Long id);

    void deleteById(Long id);
}
