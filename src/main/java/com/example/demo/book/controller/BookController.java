package com.example.demo.book.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.book.BookRepository;
import com.example.demo.book.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * http://localhost:8080/getListOfAllBooks
	 * 
	 * @return
	 */
	@RequestMapping("/getListOfAllBooks")
	public String listOfAllBooks() {
		return "List of books" + bookRepository.findAll().toString().replace("[", "").replace("]", "");
	}

	/**
	 * http://localhost:8080/get?id=1
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/get")
	public String getBook(@RequestParam Long id) {
		return bookRepository.findById(id).get().toString();
	}

	/**
	 * http://localhost:8080/add
	 *  json : 
	 *  {
			"title" : "new Title",
			"author" : "new Author",
			"isbn" : "xxxx-xxxx-xx-x"
		}
	 * @param book
	 * @return
	 */
	
	@PostMapping("/add")
	ResponseEntity<String> addBook(@RequestBody BookDTO book) {
		BookDTO result = bookRepository.save(book);
		return ResponseEntity.ok(result == null ? "Book wasn't added" : "Book was added , the id=" + result.getId());
	}
}
