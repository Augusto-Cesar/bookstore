package com.acm.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acm.bookstore.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByName(String name);

}
