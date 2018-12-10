package by.it_academy.library.dao.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.it_academy.library.dao.AllDao;
import by.it_academy.library.entity.Author;
import by.it_academy.library.entity.Book;

import static by.it_academy.library.dao.util.DaoConstantStorage.*;

public class LibraryDaoSQLImpl implements AllDao {

	@Override
	public List<Author> getAuthors() {
		List<Author> authors = new ArrayList<>();
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt1 = con.createStatement();
			ResultSet res1 = stmt1.executeQuery(REQUEST_INFO_AUTHOR);
			while (res1.next()) {
				authors.add(new Author(res1.getInt(COMMAND_ID_GENERAL), res1.getString(COMMAND_NAME_AUTHOR),
						res1.getString(COMMAND_SURNAME_AUTHOR), res1.getInt(COMMAND_AGE_AUTHOR)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return authors;
	}

	@Override
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt1 = con.createStatement();
			ResultSet res1 = stmt1.executeQuery(REQUEST_INFO_BOOK);
			while (res1.next()) {
				books.add(new Book(res1.getInt(COMMAND_ID_GENERAL), res1.getString(COMMAND_NAME_BOOK)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return books;
	}

	@Override
	public List<Book> searchAuthor(int idAuthor) {
		List<Book> books = new ArrayList<>();
		int count = 1;
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt1 = con.createStatement();
			ResultSet res1 = stmt1.executeQuery(REQUEST_ALL_INFORMATION);
			while (res1.next()) {
				if (idAuthor == res1.getInt(COMMAND_ID_AUTHOR)) {
					books.add(new Book(count, res1.getString(COMMAND_NAME_BOOK)));
					count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (books.isEmpty())
			books.add(new Book(idAuthor, "јвтора с таким id нет"));

		return books;
	}

	@Override
	public List<Book> rowBook(int idBook) {
		List<Book> books = new ArrayList<>();
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt1 = con.createStatement();
			ResultSet res1 = stmt1.executeQuery(REQUEST_INFO_BOOK);
			while (res1.next()) {
				if (idBook == res1.getInt(COMMAND_ID_GENERAL)) {
					Book book = new Book(res1.getInt(COMMAND_ID_GENERAL), res1.getString(COMMAND_NAME_BOOK));
					books.add(book);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (books.isEmpty())
			books.add(new Book(idBook, " ниги с таким id нет"));

		return books;
	}

	@Override
	public void addInfo() {
		Author author = fillAuthor();
		int size = amountBook();
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			String query = "INSERT INTO author (name, surname, age) values (?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString(1, author.getName());
		    preparedStmt.setString(2, author.getSurName());
		    preparedStmt.setInt(3, author.getAge());
		    preparedStmt.executeUpdate();
			
			for (int i = 0; i < size; i++) {
				addBook();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addBook() {
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			String query = "INSERT INTO book (title) values (?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString(1, fillBook());
		    preparedStmt.executeUpdate();
		    addCall();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addCall() {
		int maxIDAuthor = maxIdAuthors();
		int maxIDBook = maxIdBooks();
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			String query = "INSERT INTO author_and_book (id_author, id_book) values (?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, maxIDAuthor);
		    preparedStmt.setInt(2, maxIDBook);
		    preparedStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int maxIdAuthors() {
		int size = 0;
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt1 = con.createStatement();
			ResultSet res1 = stmt1.executeQuery(REQUEST_MAX_AUTHOR);
			while (res1.next()) {
				size = res1.getInt(COMMAND_MAX_ID_AUTHOR);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return size;
	}

	private int maxIdBooks() {
		int size = 0;
		try {
			Class.forName(FIELD_DYNAMIC_DRIVER_LOADING).newInstance();
			Connection con = DriverManager.getConnection(FIELD_URL, FIELD_USER_NAME, FIELD_PASSWORD);
			Statement stmt1 = con.createStatement();
			ResultSet res1 = stmt1.executeQuery(REQUEST_MAX_BOOK);
			while (res1.next()) {
				size = res1.getInt(COMMAND_MAX_ID_BOOKS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return size;
	}

	private Author fillAuthor() {
		System.out.print("¬ведите им€ автора: ");
		String name = input();
		System.out.print("¬ведите фамилию автора: ");
		String surname = input();
		System.out.print("¬ведите возраст автора: ");
		int age = Integer.parseInt(input());
		Author author = new Author(1, name, surname, age);

		return author;
	}

	private String fillBook() {
		System.out.print("¬ведите название книги: ");
		String title = input();

		return title;
	}

	private int amountBook() {
		System.out.print("—колько добавить книг: ");
		int size = Integer.parseInt(input());

		return size;
	}

	private String input() {
		String line = "";
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		try {
			line = read.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return line;
	}
}
