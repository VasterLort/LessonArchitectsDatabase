package by.it_academy.library.dao;

import java.util.List;

import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;

public interface AllDao {
	List<Author> getAuthors();
	List<Book> getBooks();
	List<Book> searchAuthor(int idAuthor);
	List<Book> rowBook(int idBook);
	void addInfo();
}
