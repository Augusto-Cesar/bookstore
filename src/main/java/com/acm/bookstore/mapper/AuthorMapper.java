package com.acm.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.acm.bookstore.dto.AutorDTO;
import com.acm.bookstore.entity.Autor;

@Mapper
public interface AuthorMapper {
	
	AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
	
	Autor toModel(AutorDTO autorDTO);
	
	AutorDTO toDTO(Autor autor);
	
}
