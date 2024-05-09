package com.api.book.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookServices {
	
	@Autowired
	private BookRepository bookRepository;
///**	private static List<Book> list = new ArrayList<>();
//}
//	static {
//		list.add(new Book(12, "Hi This is Xduce", "Sans"));
//		list.add(new Book(894, "Hi This is Sans", "Xduce"));
//		list.add(new Book(84, "Hi This is Both", "Xduce, Sans"));
//	} **/

//get all book
	public List<Book> getAllBooks() {
		List <Book>list =(List<Book>)this.bookRepository.findAll();
		return list;
	}

//get single book By Id 
	public Book getBookById(int id) {
		Book book = null;
		try {
//			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			book =this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// Adding the book
	public Book addBook(Book book) {
//		list.add(book);
		Book result = bookRepository.save(book);	
		return book;
	}
	
	// delete the book
	// method1
//	public void deleteBook(int bid) {
//		// TODO Auto-generated method stub
//		list.stream().filter(book ->
//		{
//				if(book.getId() != bid) {
//				return true;
//			}else {
//				return false;
//			}
//	}
//	).collect(Collectors.toList());
//	}

	// method 2
	public void deleteBook(int bid) {
//		list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	}
	// update book

	public void updateBook(Book book, int bookId) {
//		list.stream().map(b -> {
//			if (b.getId() == bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookRepository.save(book);
	}

}
