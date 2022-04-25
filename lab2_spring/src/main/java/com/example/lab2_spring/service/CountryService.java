package com.example.lab2_spring.service;

import com.example.lab2_spring.model.Author;
import com.example.lab2_spring.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent) throws Exception;

    Optional<Country> edit(Long id, String name, String continent) throws Exception;

    void deleteById(Long id);
}
