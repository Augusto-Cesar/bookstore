package com.acm.bookstore.utils;

import com.acm.bookstore.dto.AutorDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonConverter {
	
	public static String asJsonString(AutorDTO expecetdCreatedAutorDTO) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objectMapper.registerModule(new JavaTimeModule());
			
			return objectMapper.writeValueAsString(expecetdCreatedAutorDTO);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
}
