package by.it_academy.library.service;

import by.it_academy.library.entity.AuthorCatalog;
import by.it_academy.library.entity.BookCatalog;

public interface AllCatalogService {
	AuthorCatalog authorCatalog();
	BookCatalog bookCatalog();
	BookCatalog listBooksOfAuthor(int idAuthor);
	BookCatalog rowBook(int idBook);
	void addInfo();
}
