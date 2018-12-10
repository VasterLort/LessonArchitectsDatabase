package by.it_academy.library.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorCatalog {
	private String resposniblePerson;
	private Date creationDate;
	private List<Author> author;

	public AuthorCatalog() {
		this.author = new ArrayList<>();
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

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookCatalog [resposniblePerson = " + resposniblePerson + ", creationDate = " + creationDate
				+ "]" + "\n" + "authors: " + "\n" + author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
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
		AuthorCatalog other = (AuthorCatalog) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
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
