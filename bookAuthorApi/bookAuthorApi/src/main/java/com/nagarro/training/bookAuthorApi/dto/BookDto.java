package com.nagarro.training.bookAuthorApi.dto;

import java.util.Date;

public class BookDto {

	public BookDto(int id, String title, String author, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
	}

	public BookDto() {
		super();
	}

	private int id;
	private String title;
	private String author;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
