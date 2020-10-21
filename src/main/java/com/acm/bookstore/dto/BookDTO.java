package com.acm.bookstore.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.acm.bookstore.entity.Autor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	
	private Long id;
	
	@NotBlank
	@Size(max = 200)
	private String name;
	
	@NotNull
	private Integer pages;
	
	@NotNull
	private Integer chapters;
	
	@NotBlank
	@Size(max = 100)
	@Pattern(regexp = "(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[-●]?[0-9]+[-●]?[0-9]+[-●]?[0-9X]$",
			message = "Formato inválido para ISBN")
	private String isbn;
	
	@NotBlank
	@Size(max = 200)
	private String publisherName;
	
	@Valid
	@NotNull
	private Autor autor;
}
