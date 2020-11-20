package com.acm.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acm.bookstore.service.PublisherService;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {
	
	private PublisherService publisherService;

	@Autowired
	public PublisherController(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	

}
