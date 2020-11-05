package com.acm.bookstore.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.acm.bookstore.builder.AutorDTOBuilder;
import com.acm.bookstore.dto.AutorDTO;
import com.acm.bookstore.entity.Autor;
import com.acm.bookstore.exception.AutorAlreadyExistsException;
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
	
	@Test
	void whenNewAuthorIsInformedThenItShouldBeCreated() {
//		given
		AutorDTO expectedAutorTocreatedDTO = autorDTOBuilder.buildAutorDTO();
		Autor expectedCreatedAuthor = authorMapper.toModel(expectedAutorTocreatedDTO);
		
//		when
		when(autorRepository.save(expectedCreatedAuthor)).thenReturn(expectedCreatedAuthor);
		when(autorRepository.findByName(expectedAutorTocreatedDTO.getName())).thenReturn(Optional.empty());
		
		AutorDTO createdAuthorDTO = autorService.create(expectedAutorTocreatedDTO);
		
//		then 
		assertThat(createdAuthorDTO, is(equalTo(expectedAutorTocreatedDTO)));
	}
	
	@Test
	void whenExistingAuthorIsInformedThenAnExceptionShouldBeThrown() {
//		given
		AutorDTO expectedAutorTocreatedDTO = autorDTOBuilder.buildAutorDTO();
		Autor expectedCreatedAuthor = authorMapper.toModel(expectedAutorTocreatedDTO);
		
//		when
		when(autorRepository.findByName(expectedAutorTocreatedDTO.getName()))
			.thenReturn(Optional.of(expectedCreatedAuthor));
		
		assertThrows(AutorAlreadyExistsException.class, () -> autorService.create(expectedAutorTocreatedDTO));
	}
}
