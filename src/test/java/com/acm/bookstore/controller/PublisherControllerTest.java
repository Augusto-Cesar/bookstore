package com.acm.bookstore.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.acm.bookstore.builder.PublisherDTOBuilder;
import com.acm.bookstore.service.PublisherService;

@ExtendWith(MockitoExtension.class)
public class PublisherControllerTest {
	
	private final static String PUBLLISHER_API_URL_PATH = "/api/v1/publishers";
	
	private MockMvc mockMvc;
	
	@Mock
	private PublisherService publisherService;
	
	@InjectMocks
	private PublisherController publisherController;
	
	private PublisherDTOBuilder publisherDTOBuilder;
	
	@BeforeEach
	void setUp() {
		publisherDTOBuilder = PublisherDTOBuilder.builder().build();
		mockMvc = MockMvcBuilders.standaloneSetup(publisherController)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((s, locale) -> new MappingJackson2JsonView())
				.build();
	}
}
