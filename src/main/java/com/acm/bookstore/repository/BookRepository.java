package com.acm.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acm.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
