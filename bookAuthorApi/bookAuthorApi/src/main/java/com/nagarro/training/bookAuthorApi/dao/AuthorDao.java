package com.nagarro.training.bookAuthorApi.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.training.bookAuthorApi.domain.Author;

public interface AuthorDao extends CrudRepository<Author, Integer> {

	public Author findByName(final String name);

}
