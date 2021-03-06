package com.acm.bookstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.acm.bookstore.entity.auditory.Auditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Auditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, columnDefinition = "integer default 0")
	private Integer pages;
	
	@Column(nullable = false, columnDefinition = "integer default 0")
	private Integer chapters;
	
	@Column(nullable = false)
	private String isbn;
	
	@Column(name = "publisher_name", nullable = false, unique = true)
	private String publisherName;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Autor autor;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Publisher publisher;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	private User user;
}
