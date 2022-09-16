package com.nagarro.training.bookAuthorApi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.bookAuthorApi.dto.BookDto;
import com.nagarro.training.bookAuthorApi.service.BookServiceImpl;

@RestController
public class BookController {

	@Autowired
	private BookServiceImpl bookService;

	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getAllBooks() {

		final List<BookDto> listOfBooks = bookService.getAllBooks();
		if (listOfBooks.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(listOfBooks);// Returns JSONS
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BookDto> getBookById(@PathVariable("id") int id) {
		final BookDto bookDto = bookService.getBookById(id);
		if (bookDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bookDto));
	}

	@PostMapping(value = "/books")
	public ResponseEntity<BookDto> addBook(@Validated @RequestBody BookDto bookDto) {
		try {
			final BookDto b = this.bookService.addBook(bookDto);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {

		try {
			bookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/books/{bookId}")
	public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto, @PathVariable("bookId") int bookId) {
		try {
			this.bookService.updateBook(bookDto, bookId);
			return ResponseEntity.ok().body(bookDto);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
