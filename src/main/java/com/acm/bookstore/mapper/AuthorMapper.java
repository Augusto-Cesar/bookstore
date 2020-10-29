package com.acm.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.acm.bookstore.dto.AutorDTO;
import com.acm.bookstore.entity.Autor;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorMapper {
	
	AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
	
	@Mapping(target = "books", ignore = true)
	Autor toModel(AutorDTO autorDTO);
	
	AutorDTO toDTO(Autor autor);
	
}
