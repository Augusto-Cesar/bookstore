package com.acm.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bookstore.dto.AutorDTO;
import com.acm.bookstore.entity.Autor;
import com.acm.bookstore.exception.AuthorNotFoundException;
import com.acm.bookstore.exception.AutorAlreadyExistsException;
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
	
	public AutorDTO create(AutorDTO autorDTO) {
		verifyIfExists(autorDTO.getName());
		
		Autor autorToCreate = authorMapper.toModel(autorDTO);
		Autor createdAutor = autorRepository.save(autorToCreate);
		return authorMapper.toDTO(createdAutor);
	}
	
	public AutorDTO findById(Long id) {
		Autor autor =  autorRepository.findById(id)
		.orElseThrow(() -> new AuthorNotFoundException(id));
		return authorMapper.toDTO(autor);
	}

	private void verifyIfExists(String autorName) {
		autorRepository.findByName(autorName)
			.ifPresent(autor -> { throw new AutorAlreadyExistsException(autorName); });
	}
	
}
