package com.example.lab2_spring.service.impl;

import com.example.lab2_spring.model.Author;
import com.example.lab2_spring.model.Book;
import com.example.lab2_spring.model.Category;
import com.example.lab2_spring.model.DTO.BookDto;
import com.example.lab2_spring.repository.AuthorRepository;
import com.example.lab2_spring.repository.BookRepository;
import com.example.lab2_spring.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = authorRepository.findById(authorId).orElseThrow(RuntimeException::new);
        return Optional.of(bookRepository.save(new Book(name, category, author, availableCopies)));
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.author).orElseThrow(RuntimeException::new);
        return Optional.of(bookRepository.save(new Book(bookDto.name, bookDto.category, author, bookDto.availableCopies)));
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        book.setName(name);
        book.setCategory(category);
        Author author = authorRepository.findById(authorId).orElseThrow(RuntimeException::new);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        Author author = authorRepository.findById(bookDto.getAuthor()).orElseThrow(RuntimeException::new);
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> markBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        if(book.getAvailableCopies()>0)
        book.setAvailableCopies(book.getAvailableCopies()-1);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
