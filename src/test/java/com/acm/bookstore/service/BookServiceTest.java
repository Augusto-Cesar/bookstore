package com.acm.bookstore.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.acm.bookstore.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;
	
//	"Aqui seria um teste passando um id inesistente"
	@Test
	void idNotFoundException( ) {
//		var invalidId = 10L;
//		
//		when(bookRepository.findById(invalidId)).thenReturn(Optional.ofNullable(any(Book.class)));
//		
//		assertThrows(BookNotFoundException.class, () -> bookService.findById(invalidId));
	}
}
