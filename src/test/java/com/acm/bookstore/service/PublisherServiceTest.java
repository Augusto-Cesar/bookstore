package com.acm.bookstore.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.acm.bookstore.builder.PublisherDTOBuilder;
import com.acm.bookstore.mapper.PublisherMapper;
import com.acm.bookstore.repository.PublisherRepository;

@ExtendWith(MockitoExtension.class)
public class PublisherServiceTest {
	
	private final PublisherMapper publisherMapper = PublisherMapper.INSTANCE;
	
	@Mock
	private PublisherRepository publisherRepository;
	
	@InjectMocks
	private PublisherService publisherService;
	
	private PublisherDTOBuilder publisherDTOBuilder;
	
	@BeforeEach
	void setUp() {
		publisherDTOBuilder = PublisherDTOBuilder.builder().build();
	}
	
}
