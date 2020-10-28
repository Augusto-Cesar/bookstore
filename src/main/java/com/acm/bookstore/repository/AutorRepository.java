package com.acm.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acm.bookstore.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
