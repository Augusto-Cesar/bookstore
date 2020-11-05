package com.acm.bookstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acm.bookstore.dto.AutorDTO;
import com.acm.bookstore.service.AutorService;

@RestController
@RequestMapping("/api/v1/authors")
public class AutorController {
	
	private AutorService autorService;

	@Autowired
	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AutorDTO create(@RequestBody @Valid AutorDTO autorDTO) {
		return autorService.create(autorDTO);
	}
	
}
