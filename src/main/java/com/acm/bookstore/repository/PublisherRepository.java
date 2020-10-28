package com.acm.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acm.bookstore.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
