package com.nagarro.training.bookAuthorApi.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name = "list_of_books")
public class Book {

	@Id
	private int id;
	private String title;

	@ManyToOne
	@JsonManagedReference // Here, we have author_id column, That's why
	private Author author;

	public Book() {
		super();
	}

	@Temporal(TemporalType.DATE)
	private Date date;

	public Book(int id, String title, Author author, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
