package com.nagarro.training.bookAuthorApi.service;

import java.util.List;

import com.nagarro.training.bookAuthorApi.dto.AuthorDto;

public interface AuthorService {
	List<AuthorDto> getAllAuthors();
}
