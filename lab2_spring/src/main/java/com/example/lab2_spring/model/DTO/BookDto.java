package com.example.lab2_spring.model.DTO;

import com.example.lab2_spring.model.Author;
import com.example.lab2_spring.model.Category;
import lombok.Data;

@Data
public class BookDto {
    public String name;
    public Category category;
    public Long author;
    public Integer availableCopies;
}
