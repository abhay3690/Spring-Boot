package com.api.book.controller;

import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.Services.BookServices;
import com.api.book.entities.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;

@RestController

//@Controller
public class BookController {
//	@RequestMapping(value ="/books", method = RequestMethod.GET)
	@Autowired

	private BookServices bookservice;

	public BookServices getBookservice() {
		return bookservice;
	}

	public void setBookservice(BookServices bookservice) {
		this.bookservice = bookservice;
	}

//get all books
	@GetMapping("/abhay")
	public ResponseEntity<List<Book>> getBooks() {
		System.out.println("Hello Abhay");
		List<Book> list = this.bookservice.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
//		return this.bookservice.getAllBooks();
	}

//get single book handle
	@GetMapping("/abhay/{id}")
	public ResponseEntity getBook(@PathVariable("id") int id) {
		Book book = bookservice.getBookById(id);
		{
			if (book == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
		return ResponseEntity.of(Optional.of(book));
//		return bookservice.getBookById(id);
	}

// create a new book handler
	@PostMapping("/abhay")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = bookservice.addBook(book);
			System.out.println(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//delete book handler
	@DeleteMapping("/abhay/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			this.bookservice.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

// update book
	@PutMapping("/abhay/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		try {
			this.bookservice.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
