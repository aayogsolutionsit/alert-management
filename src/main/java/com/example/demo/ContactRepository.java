package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findByEmailContaining(String email);
    List<Contact>findByDobBetween(LocalDate start, LocalDate end);
}
