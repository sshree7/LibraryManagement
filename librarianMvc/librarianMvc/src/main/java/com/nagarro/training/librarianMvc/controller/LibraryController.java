package com.nagarro.training.librarianMvc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.training.librarianMvc.dto.BookDto;
import com.nagarro.training.librarianMvc.service.LibraryService;
import com.nagarro.training.librarianMvc.service.UserLoginService;

@Controller
public class LibraryController {
	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private LibraryService libraryService;

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	@PostMapping(value = "/welcome")
	public String welcome(@RequestParam final String username, final String password, Model model) {
		try {
			if (userLoginService.isValidUser(username, password)) {
				return "welcome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}

	@PostMapping(value = "/addForm")
	public String addBooktoDB(@RequestParam String id, String title, String author, String date) {
		int bookId = Integer.parseInt(id);
		BookDto bookDto = new BookDto(bookId, title, author, new Date());
		libraryService.addBook(bookDto);
		return "redirect:/welcome";

	}

	@PostMapping(value = "/editForm")
	public String editForm(@RequestParam String id, String title, String author, String date) {
		int bookId = Integer.parseInt(id);
		BookDto bookDto = new BookDto(bookId, title, author, new Date());
		libraryService.updateBook(bookDto);
		return "redirect:/welcome";
	}

	@GetMapping("/editBook")
	public String editBook(@RequestParam("id") String id, Model model) {
		int bookId = Integer.parseInt(id);
		model.addAttribute("id", id);
		BookDto book = libraryService.getBookById(bookId);
		model.addAttribute("book", book);
		return "editBook";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") String id) {
		int bookId = Integer.parseInt(id);
		libraryService.deleteBook(bookId);
		return "forward:/welcome";
	}

	@GetMapping("/welcome")
	public String redirect() {
		return "welcome";
	}

	@RequestMapping("/logout")
	public String logOut() {
		return "login";
	}

	@PostMapping("/addBook")
	public String addBook() {
		return "addBook";
	}

}
