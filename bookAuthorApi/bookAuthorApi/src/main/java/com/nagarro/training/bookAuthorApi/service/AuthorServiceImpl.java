package com.nagarro.training.bookAuthorApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.bookAuthorApi.dao.AuthorDao;
import com.nagarro.training.bookAuthorApi.domain.Author;
import com.nagarro.training.bookAuthorApi.dto.AuthorDto;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	public List<AuthorDto> getAllAuthors() {
		List<Author> authorList= (List<Author>) this.authorDao.findAll();
		List<AuthorDto> authorDtoList = new ArrayList<>();
		for (Author author : authorList) {
			authorDtoList.add(new AuthorDto(author.getId(),  author.getName()));
		}
		
		return authorDtoList;
	}

}
