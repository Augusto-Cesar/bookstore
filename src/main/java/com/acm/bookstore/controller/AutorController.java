package com.acm.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acm.bookstore.service.AutorService;

@RestController
@RequestMapping("/api/v1/authors")
public class AutorController {
	
	private AutorService autorService;

	@Autowired
	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}
	
	
	
}
