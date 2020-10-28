package com.acm.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acm.bookstore.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
