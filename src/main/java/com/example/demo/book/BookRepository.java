package com.example.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.book.dto.BookDTO;

public interface BookRepository extends JpaRepository<BookDTO, Long> {

}
