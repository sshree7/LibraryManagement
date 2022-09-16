package com.nagarro.training.librarianMvc.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.librarianMvc.dto.AuthorDto;
import com.nagarro.training.librarianMvc.dto.BookDto;

@Service
public class LibraryServiceImpl implements LibraryService {

	final RestTemplate restTemplate = new RestTemplate();
	final String BOOK_API = "http://localhost:8080/books";
	final String AUTHOR_API = "http://localhost:8080/authors";
	// private static final String DELETE_EMPLOYEE_ENDPOINT_URL =
	// "http://localhost:8080/books/{id}";

	public List<BookDto> getAllBooks() {
		BookDto[] bookList = restTemplate.getForObject(BOOK_API, BookDto[].class);
		return Arrays.asList(bookList);
	}

	public List<AuthorDto> getAllAuthors() {
		AuthorDto[] authorList = restTemplate.getForObject(AUTHOR_API, AuthorDto[].class);
		return Arrays.asList(authorList);
	}

	public boolean addBook(BookDto bookDto) {
		ResponseEntity<BookDto> createResponse = restTemplate.postForEntity(BOOK_API, bookDto, BookDto.class);
		return createResponse.getStatusCodeValue() == 200;
	}

	public BookDto getBookById(int bookId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", bookId + "");
		BookDto bookDto = restTemplate.getForObject(BOOK_API + "/" + bookId, BookDto.class, params);
		return bookDto;
	}

	public void updateBook(BookDto bookDto) {
		Map<String, String> params = new HashMap<String, String>();
		int bookId = bookDto.getId();
		params.put("id", bookId + "");
		restTemplate.put(BOOK_API + "/" + bookId, bookDto, params);
		// restTemplate.put(BOOK_API + "/" + bookId, bookDto);
	}

	public void deleteBook(int bookId) {
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("id", bookId + "");
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.delete(DELETE_EMPLOYEE_ENDPOINT_URL , params);
		restTemplate.delete(BOOK_API + "/" + bookId);
	}
}
