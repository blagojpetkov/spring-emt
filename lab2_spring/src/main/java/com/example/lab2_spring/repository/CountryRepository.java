package com.example.lab2_spring.repository;

import com.example.lab2_spring.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
