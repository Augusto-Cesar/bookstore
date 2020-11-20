package com.acm.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.acm.bookstore.dto.PublisherDTO;
import com.acm.bookstore.entity.Publisher;

@Mapper
public interface PublisherMapper {

	PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);
	
	@Mapping(target = "books", ignore = true)
	Publisher toModel(PublisherDTO dto);
	
	PublisherDTO toDTO(Publisher publisher);
	
}
