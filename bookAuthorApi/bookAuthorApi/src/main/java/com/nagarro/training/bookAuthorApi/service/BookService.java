package com.nagarro.training.bookAuthorApi.service;

import java.util.List;

import com.nagarro.training.bookAuthorApi.domain.Book;
import com.nagarro.training.bookAuthorApi.dto.BookDto;

public interface BookService {

	BookDto addBook(final BookDto bookDto);

	void updateBook(final Book book, final int bookId);

	List<BookDto> getAllBooks();

	Book getBookById(final int id);

	void deleteBook(final int bookId);

}
