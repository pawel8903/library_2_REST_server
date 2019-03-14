package pl.pawel.restServerSide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.pawel.restServerSide.entity.Book;
import pl.pawel.restServerSide.exception.NotFoundException;
import pl.pawel.restServerSide.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/bookList")
	public List<Book> getBooks(){
		
		return bookService.getBooks();
	}
	
	@GetMapping("/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		Book book = bookService.getBook(bookId);
		
		if(book == null) {
			throw new NotFoundException("Book id not found:"+bookId);
		}
		return book;
	}
	
	@PostMapping()
	public Book addBook(@RequestBody Book book) {
		book.setId(0);
		System.out.println(book.getAvailableNumber());
		bookService.saveBook(book);
		
		return book;
	}
	
	@PutMapping()
	public Book updateBook(@RequestBody Book book) {
		bookService.saveBook(book);
		
		return book;
	}
	
	@DeleteMapping("/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		Book book = bookService.getBook(bookId);
		if(book ==null) {
			throw new NotFoundException("Book id not found:"+bookId);
		}
		bookService.deleteBook(bookId);
		
		return "Delete book id: " + bookId;
	}
}
