package pl.pawel.restServerSide.service;

import java.util.List;

import pl.pawel.restServerSide.entity.Book;

public interface BookService {

	List<Book> getBooks();

	Book getBook(int bookId);

	void saveBook(Book book);

	void deleteBook(int bookId);

}
