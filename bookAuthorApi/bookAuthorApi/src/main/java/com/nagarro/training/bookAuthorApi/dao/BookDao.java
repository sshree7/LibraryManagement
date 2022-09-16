package com.nagarro.training.bookAuthorApi.dao;

import org.springframework.data.repository.CrudRepository;
import com.nagarro.training.bookAuthorApi.domain.Book;

public interface BookDao extends CrudRepository<Book, Integer> {

	public Book findById(final int id);

}
