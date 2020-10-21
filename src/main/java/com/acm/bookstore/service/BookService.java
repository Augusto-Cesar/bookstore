package com.acm.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bookstore.dto.BookDTO;
import com.acm.bookstore.dto.MessageResponseDTO;
import com.acm.bookstore.entity.Book;
import com.acm.bookstore.exception.BookNotFoundException;
import com.acm.bookstore.mapper.BookMapper;
import com.acm.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepository;
	private final BookMapper bookMapper = BookMapper.INSTANCE;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public MessageResponseDTO create(BookDTO bookDTO) {
		Book bookToSave = bookMapper.toModel(bookDTO);		
		Book savedBook = bookRepository.save(bookToSave);
		return MessageResponseDTO.builder().message("Book created with id: " + savedBook.getId()).build();
	}

	public BookDTO findById(Long id) throws BookNotFoundException {
		Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
		
		return bookMapper.toDTO(book);		
	}
	
}
