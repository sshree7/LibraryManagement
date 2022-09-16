package com.nagarro.training.bookAuthorApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.bookAuthorApi.dto.AuthorDto;
import com.nagarro.training.bookAuthorApi.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

//	@ResponseBody// Already included in @RestController
	@GetMapping("/authors")
	public ResponseEntity<List<AuthorDto>> getAllAuthors() {

		final List<AuthorDto> listOfAuthors = authorService.getAllAuthors();
		
		if (listOfAuthors.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(listOfAuthors);// Returns JSONS
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
