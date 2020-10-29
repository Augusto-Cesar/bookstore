package com.acm.bookstore.builder;

import com.acm.bookstore.dto.AutorDTO;

import lombok.Builder;

@Builder
public class AutorDTOBuilder {
	
	@Builder.Default
	private final Long id = 1L;

	@Builder.Default
	private final String name = "Augusto Cesar";
	
	@Builder.Default
	private final int age = 21;
	
	public AutorDTO buildAutorDTO() {
		return new AutorDTO(id, name, age);
	}
}
