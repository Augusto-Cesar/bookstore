package com.acm.bookstore.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.acm.bookstore.builder.AutorDTOBuilder;
import com.acm.bookstore.dto.AutorDTO;
import com.acm.bookstore.service.AutorService;
import com.acm.bookstore.utils.JsonConverter;

@ExtendWith(MockitoExtension.class)
public class AutorControllerTest {
	
	private static final String AUTHOR_API_URL_PATH = "/api/v1/authors";

	@Mock
	private AutorService autorService;
	
	@InjectMocks
	private AutorController autorController;
	
	private MockMvc mockMvc;
	
	private AutorDTOBuilder autorDTOBuilder;
	
	@BeforeEach
	void setUp() {
		autorDTOBuilder = AutorDTOBuilder.builder().build();
		mockMvc = MockMvcBuilders.standaloneSetup(autorController)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((s, locale) -> new MappingJackson2JsonView())
				.build();
	}
	
	@Test
	void whenPOSTIsCalledThenStatusCreatedShouldBeReturned() throws Exception {
		AutorDTO expecetdCreatedAutorDTO = autorDTOBuilder.buildAutorDTO();
		
		when(autorService.create(expecetdCreatedAutorDTO))
			.thenReturn(expecetdCreatedAutorDTO);
		
		mockMvc.perform(post(AUTHOR_API_URL_PATH).
				contentType(MediaType.APPLICATION_JSON)
				.content(JsonConverter.asJsonString(expecetdCreatedAutorDTO)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", Is.is(expecetdCreatedAutorDTO.getId().intValue())))
				.andExpect(jsonPath("$.name", Is.is(expecetdCreatedAutorDTO.getName())))
				.andExpect(jsonPath("$.age", Is.is(expecetdCreatedAutorDTO.getAge())));
	}
	
	@Test
	void whenPOSTIsCalledWithoutRequiredFieldThenBadRequestStatusShouldBeInformed() throws Exception {
		AutorDTO expecetdCreatedAutorDTO = autorDTOBuilder.buildAutorDTO();
		expecetdCreatedAutorDTO.setName(null);
		
		mockMvc.perform(post(AUTHOR_API_URL_PATH).
				contentType(MediaType.APPLICATION_JSON)
				.content(JsonConverter.asJsonString(expecetdCreatedAutorDTO)))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	void quandoIdEncontradoStatusOkRetornado() throws Exception {
		AutorDTO expectedAutorDTO = autorDTOBuilder.buildAutorDTO();
		
		when(autorService.findById(expectedAutorDTO.getId()))
			.thenReturn(expectedAutorDTO);
		
		mockMvc.perform(get(AUTHOR_API_URL_PATH + "/" + expectedAutorDTO.getId()).
				contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Is.is(expectedAutorDTO.getId().intValue())))
				.andExpect(jsonPath("$.name", Is.is(expectedAutorDTO.getName())))
				.andExpect(jsonPath("$.age", Is.is(expectedAutorDTO.getAge())));
	}
	
	@Test
	void quandoListaChamadaStatusOkRetornado() throws Exception {
		AutorDTO expectedAutorDTO = autorDTOBuilder.buildAutorDTO();
		
		when(autorService.findAll())
			.thenReturn(Collections.singletonList(expectedAutorDTO));
		
		mockMvc.perform(get(AUTHOR_API_URL_PATH).
				contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", Is.is(expectedAutorDTO.getId().intValue())))
				.andExpect(jsonPath("$[0].name", Is.is(expectedAutorDTO.getName())))
				.andExpect(jsonPath("$[0].age", Is.is(expectedAutorDTO.getAge())));
	}
	
	@Test
	void quandoDeletarIdValidoNoContentRetornado() throws Exception {
		AutorDTO expectedAutorDTO = autorDTOBuilder.buildAutorDTO();
		
		var expectedId = expectedAutorDTO.getId();
		doNothing().when(autorService).deleteById(expectedId);
		
		mockMvc.perform(delete(AUTHOR_API_URL_PATH + "/" + expectedId)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
		
		 
	}
}
