package pl.pawel.restServerSide.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import pl.pawel.restServerSide.entity.Book;

public interface BookRepository extends Repository<Book, Integer> {

	List<Book> findAll();

	Book findById(int bookId);

	void save(Book book);

	void deleteById(int bookId);

}
