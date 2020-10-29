package com.acm.bookstore.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.acm.bookstore.builder.AutorDTOBuilder;
import com.acm.bookstore.dto.AutorDTO;
import com.acm.bookstore.mapper.AuthorMapper;
import com.acm.bookstore.repository.AutorRepository;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTest {
	
	private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;
	
	@Mock
	private AutorRepository autorRepository;
	
	@InjectMocks
	private AutorService autorService;
	
	private AutorDTOBuilder autorDTOBuilder;
	
	@BeforeEach
	void setUp() {
		autorDTOBuilder = AutorDTOBuilder.builder().build();
	}
	
}
