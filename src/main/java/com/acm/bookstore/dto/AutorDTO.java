package com.acm.bookstore.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
	
	private Long id;
	
	@NotNull(message = "Favor informar o nome do autor!")
	@NotEmpty
	@Size(max = 255)
	private String name;
	
	@NotNull
	@Max(120)
	private Integer age;

}
