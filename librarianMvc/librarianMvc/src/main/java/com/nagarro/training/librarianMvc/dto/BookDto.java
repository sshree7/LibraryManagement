package com.nagarro.training.librarianMvc.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

	private int id;
	private String title;
	private String author;
	private Date date;

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
