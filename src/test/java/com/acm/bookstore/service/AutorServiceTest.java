package com.acm.bookstore.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
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
import com.acm.bookstore.exception.AuthorNotFoundException;
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
	
	@Test
	void quandoIdEncontradoAutorERetornado() {
		AutorDTO expectedAutorDTO = autorDTOBuilder.buildAutorDTO();
		Autor expectedAuthor = authorMapper.toModel(expectedAutorDTO);
		
		when(autorRepository.findById(expectedAutorDTO.getId())).thenReturn(Optional.of(expectedAuthor));
		
		AutorDTO autorDTO = autorService.findById(expectedAutorDTO.getId());
		
		assertThat(autorDTO, is(equalTo(expectedAutorDTO)));
	}
	
	@Test
	void quandoIdNaoEncontradoUmaExcecaoLancada() {
		AutorDTO expectedAutorDTO = autorDTOBuilder.buildAutorDTO();
		
		when(autorRepository.findById(expectedAutorDTO.getId())).thenReturn(Optional.empty());
		
		assertThrows(AuthorNotFoundException.class, () -> autorService.findById(expectedAutorDTO.getId()));
	}
	
	@Test
	void quandoListaAutorChamadaEntaoRetornaLista() {
		AutorDTO expectedAutorDTO = autorDTOBuilder.buildAutorDTO();
		Autor expectedAuthor = authorMapper.toModel(expectedAutorDTO);
		
		when(autorRepository.findAll()).thenReturn(Collections.singletonList(expectedAuthor));
		
		List<AutorDTO> autorDTOList = autorService.findAll();
		
		assertThat(autorDTOList.size(), is(1));
		assertThat(autorDTOList.get(0), is(equalTo(expectedAutorDTO)));
		
	}
	
	@Test
	void quandoListaAutorChamadaRetornaListaVazia() {
		when(autorRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
		
		List<AutorDTO> autorDTOList = autorService.findAll();
		
		assertThat(autorDTOList.size(), is(0));
	}
	
	@Test
	void quandoIdEncontradoAutorEDeletado() {
		AutorDTO expectedAutorDTO = autorDTOBuilder.buildAutorDTO();
		Autor expectedAuthor = authorMapper.toModel(expectedAutorDTO);
		
		Long expectedId = expectedAutorDTO.getId();
		doNothing().when(autorRepository).deleteById(expectedId);
		when(autorRepository.findById(expectedId)).thenReturn(Optional.of(expectedAuthor));
		
		autorService.deleteById(expectedId);
		
		verify(autorRepository, times(1)).deleteById(expectedId);
		verify(autorRepository, times(1)).findById(expectedId);
	}
	
	@Test
	void quandoIdInvalidoUmaExcecaoLancadaAutorNaoDeletado() {
		var expectedInvalidId = 2L;
	
		when(autorRepository.findById(expectedInvalidId)).thenReturn(Optional.empty());
		
		assertThrows(AuthorNotFoundException.class, () -> autorService.deleteById(expectedInvalidId));
	}
}
