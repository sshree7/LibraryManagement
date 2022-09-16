package com.nagarro.training.bookAuthorApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.bookAuthorApi.dao.AuthorDao;
import com.nagarro.training.bookAuthorApi.dao.BookDao;
import com.nagarro.training.bookAuthorApi.domain.Author;
import com.nagarro.training.bookAuthorApi.domain.Book;
import com.nagarro.training.bookAuthorApi.dto.BookDto;

@Service
public class BookServiceImpl {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private AuthorDao authorDao;

//	public List<Book> getAllBooks() {
//		return (List<Book>) this.bookDao.findAll();
//	}
//	

	public List<BookDto> getAllBooks() {
		final List<Book> bookList = (List<Book>) this.bookDao.findAll();
		List<BookDto> books = new ArrayList<>();
		for (Book book : bookList) {
			books.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getDate()));
		}
		return books;
	}

	public BookDto getBookById(final int id) {
		Book book = null;
		BookDto bookDto = null;
		try {
			book = this.bookDao.findById(id);
			bookDto = new BookDto(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getDate());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookDto;
	}

	public BookDto addBook(final BookDto bookDto) {
		Author currentAuthor = authorDao.findByName(bookDto.getAuthor());
		Book book = new Book();
		book.setId(bookDto.getId());
		book.setTitle(bookDto.getTitle());
		book.setAuthor(currentAuthor);
		book.setDate(bookDto.getDate());
		Book addedBook = bookDao.save(book);
		BookDto newBookDto = new BookDto();
		newBookDto.setId(addedBook.getId());
		newBookDto.setTitle(addedBook.getTitle());
		newBookDto.setAuthor(addedBook.getAuthor().getName());
		newBookDto.setDate(addedBook.getDate());
		return newBookDto;

	}

	public void deleteBook(final int bookId) {
		bookDao.deleteById(bookId);
	}

	public void updateBook(final BookDto bookDto, final int bookId) {

		Book book = this.bookDao.findById(bookId);
		book.setId(bookId);
		book.setTitle(bookDto.getTitle());
		book.setAuthor(authorDao.findByName(bookDto.getAuthor()));
		book.setDate(bookDto.getDate());

		bookDao.save(book);
	}
}
