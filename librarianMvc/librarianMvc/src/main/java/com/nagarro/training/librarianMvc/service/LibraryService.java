package com.nagarro.training.librarianMvc.service;

import java.util.List;

import com.nagarro.training.librarianMvc.dto.BookDto;

public interface LibraryService {
	
	List<BookDto> getAllBooks();

	void deleteBook(int bookId);

	boolean addBook(BookDto bookDto);

	BookDto getBookById(int bookId);

	void updateBook(BookDto bookDto);

}
