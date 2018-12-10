package by.it_academy.library.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookCatalog {
	private String resposniblePerson;
	private Date creationDate;
	private List<Book> books;

	public BookCatalog() {
		this.books = new ArrayList<>();
	}

	public String getResposniblePerson() {
		return resposniblePerson;
	}

	public void setResposniblePerson(String resposniblePerson) {
		this.resposniblePerson = resposniblePerson;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book getSingleRow(int row) {
		if (books != null) {
			return books.get(row);
		}
		return null;
	}

	@Override
	public String toString() {
		return "BookCatalog [resposniblePerson = " + resposniblePerson + ", creationDate = " + creationDate
				+ "]" + "\n" + "books: " + "\n" + books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((resposniblePerson == null) ? 0 : resposniblePerson.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookCatalog other = (BookCatalog) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (resposniblePerson == null) {
			if (other.resposniblePerson != null)
				return false;
		} else if (!resposniblePerson.equals(other.resposniblePerson))
			return false;
		return true;
	}

}
