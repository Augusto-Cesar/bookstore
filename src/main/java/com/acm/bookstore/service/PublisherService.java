package com.acm.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bookstore.mapper.PublisherMapper;
import com.acm.bookstore.repository.PublisherRepository;

@Service
public class PublisherService {
	
	private final static PublisherMapper publisherMapper = PublisherMapper.INSTANCE;
	
	private PublisherRepository publisherRepository;

	@Autowired
	public PublisherService(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}
}
