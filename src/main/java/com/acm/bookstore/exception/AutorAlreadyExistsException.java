package com.acm.bookstore.exception;

import javax.persistence.EntityExistsException;

public class AutorAlreadyExistsException extends EntityExistsException {
	
	public AutorAlreadyExistsException(String name) {
		super(String.format("USer with name %s alread exists!", name));
	}
}
