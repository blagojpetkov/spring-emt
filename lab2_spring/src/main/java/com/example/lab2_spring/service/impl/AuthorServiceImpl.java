package com.example.lab2_spring.service.impl;

import com.example.lab2_spring.model.Author;
import com.example.lab2_spring.model.Country;
import com.example.lab2_spring.repository.AuthorRepository;
import com.example.lab2_spring.repository.CountryRepository;
import com.example.lab2_spring.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId){
        Country country = countryRepository.findById(countryId).orElseThrow(RuntimeException::new);
        return Optional.of(authorRepository.save(new Author(name, surname, country)));
    }


    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long countryId){
        Author author = authorRepository.findById(id).orElseThrow(RuntimeException::new);
        Country country = countryRepository.findById(countryId).orElseThrow(RuntimeException::new);
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
