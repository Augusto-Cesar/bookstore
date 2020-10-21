package com.acm.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.acm.bookstore.dto.BookDTO;
import com.acm.bookstore.entity.Book;

@Mapper
public interface BookMapper {
	
	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

	Book toModel(BookDTO bookDTO);
	
	BookDTO toDTO(Book book);
}
