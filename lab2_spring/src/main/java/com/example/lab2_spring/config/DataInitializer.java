package com.example.lab2_spring.config;


import com.example.lab2_spring.model.Category;
import com.example.lab2_spring.service.AuthorService;
import com.example.lab2_spring.service.BookService;
import com.example.lab2_spring.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }



    @PostConstruct
    public void initData() throws Exception {

        for (int i = 1; i < 15; i++) {
            this.countryService.save("Country " + i, "Continent " + i);
        }
        System.out.println("Countries: ");
        System.out.println(countryService.findAll().size());
        for (int i = 1; i < 15; i++) {
            this.authorService.save("Author Name" + i, "Author Surname" + i, (long) i);
        }
        System.out.println("Authors: ");
        System.out.println(authorService.findAll().size());
        for (int i = 1; i < 15; i++) {
            this.bookService.save("Book Name " + i, Category.values()[i%7], (long) i, i+5);
        }
        System.out.println("Books: ");
        System.out.println(bookService.findAll().size());
    }
}
