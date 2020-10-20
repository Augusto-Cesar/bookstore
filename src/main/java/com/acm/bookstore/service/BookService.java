package com.acm.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bookstore.controller.dto.MessageResponseDTO;
import com.acm.bookstore.entity.Book;
import com.acm.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public MessageResponseDTO create(Book book) {
		Book savedBook = bookRepository.save(book);
		return MessageResponseDTO.builder().message("Book created with id: " + savedBook.getId()).build();
	}
	
}
