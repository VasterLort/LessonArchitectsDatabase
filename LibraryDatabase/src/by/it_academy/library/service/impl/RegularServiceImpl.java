package by.it_academy.library.service.impl;

import java.util.Date;
import java.util.List;

import by.it_academy.library.dao.AllDao;
import by.it_academy.library.dao.db.LibraryDaoSQLImpl;
import by.it_academy.library.entity.BookCatalog;
import by.it_academy.library.service.AllCatalogService;
import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.AuthorCatalog;
import by.it_academy.library.entity.Book;

public class RegularServiceImpl implements AllCatalogService{
	private AllDao dao;
	
	@Override
	public AuthorCatalog authorCatalog() {
		AuthorCatalog catalog = new AuthorCatalog();
		catalog.setResposniblePerson("Liudvik Arestarhovich");
		catalog.setCreationDate(new Date());
		
		dao = new LibraryDaoSQLImpl();
		List<Author> authors = dao.getAuthors();
		catalog.setAuthor(authors);
		
		return catalog;
	}
	
	@Override
	public BookCatalog bookCatalog() {
		BookCatalog catalog = new BookCatalog();
		catalog.setResposniblePerson("Liudvik Arestarhovich");
		catalog.setCreationDate(new Date());
		
		dao = new LibraryDaoSQLImpl();
		List<Book> books = dao.getBooks();
		catalog.setBooks(books);
		
		return catalog;
	}
	
	@Override
	public BookCatalog listBooksOfAuthor(int idAuthor) {
		BookCatalog catalog = new BookCatalog();
		catalog.setResposniblePerson("Liudvik Arestarhovich");
		catalog.setCreationDate(new Date());
		
		dao = new LibraryDaoSQLImpl();
		List<Book> books = dao.searchAuthor(idAuthor);
		catalog.setBooks(books);
		
		return catalog;
	}

	@Override
	public BookCatalog rowBook(int idBook) {
		BookCatalog catalog = new BookCatalog();
		catalog.setResposniblePerson("Liudvik Arestarhovich");
		catalog.setCreationDate(new Date());
		
		dao = new LibraryDaoSQLImpl();
		List<Book> books = dao.rowBook(idBook);
		catalog.setBooks(books);
		
		return catalog;
	}

	@Override
	public void addInfo() {
		dao = new LibraryDaoSQLImpl();
		dao.addInfo();
	}

}
