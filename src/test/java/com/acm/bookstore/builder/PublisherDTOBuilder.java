package com.acm.bookstore.builder;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.acm.bookstore.dto.PublisherDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;

@Builder
public class PublisherDTOBuilder {
	
	@Builder.Default
	private final Long id = 1L;
	
	private final String name = "Editora ACM";
	
	private final String code = "ACM123456";
	
	private final LocalDate foundationDate = LocalDate.of(2020, 01, 01);
	
	public PublisherDTO buildPublisherDTO() {
		return new PublisherDTO(id, name, code, foundationDate);
	}
}
