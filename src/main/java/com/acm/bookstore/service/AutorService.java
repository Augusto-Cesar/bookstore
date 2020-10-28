package com.acm.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bookstore.mapper.AuthorMapper;
import com.acm.bookstore.repository.AutorRepository;

@Service
public class AutorService {
	
	private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;
	
	private AutorRepository autorRepository;

	@Autowired
	public AutorService(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
}
