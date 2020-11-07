package com.acm.bookstore.exception;

import javax.persistence.EntityNotFoundException;

public class AuthorNotFoundException extends EntityNotFoundException {
	
	public AuthorNotFoundException(Long id) {
		super(String.format("Autor com o id %s não existe!", id));
	}
}
