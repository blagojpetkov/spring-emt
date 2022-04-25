package com.example.lab2_spring.service;

import com.example.lab2_spring.model.Author;
import com.example.lab2_spring.model.Book;
import com.example.lab2_spring.model.Category;
import com.example.lab2_spring.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(String name, String surname, Long countryId);

    Optional<Author> edit(Long id, String name, String surname, Long countryId);

    void deleteById(Long id);
}
