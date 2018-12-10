package by.it_academy.library.dao.util;

public class DaoConstantStorage {
	private DaoConstantStorage() {
	}

	public static final String FIELD_URL = "jdbc:mysql://localhost/library?serverTimezone=Europe/Moscow&useSSL=false";
	public static final String FIELD_USER_NAME = "root";
	public static final String FIELD_PASSWORD = "1234";
	public static final String FIELD_DYNAMIC_DRIVER_LOADING = "com.mysql.cj.jdbc.Driver";
	
	public static final String REQUEST_ALL_INFORMATION = "SELECT * FROM all_information";
	public static final String REQUEST_MAX_AUTHOR = "SELECT * FROM max_id_author";
	public static final String REQUEST_MAX_BOOK = "SELECT * FROM max_id_book";
	public static final String REQUEST_INFO_AUTHOR = "SELECT * FROM author";
	public static final String REQUEST_INFO_BOOK = "SELECT * FROM book";

	public static final String COMMAND_ID_GENERAL = "id";
	
	public static final String COMMAND_ID_AUTHOR = "id_author";
	public static final String COMMAND_MAX_ID_AUTHOR = "max_id_of_authors";
	public static final String COMMAND_NAME_AUTHOR = "name";
	public static final String COMMAND_SURNAME_AUTHOR = "surname";
	public static final String COMMAND_AGE_AUTHOR = "age";
	
	public static final String COMMAND_ID_BOOK = "id_book";
	public static final String COMMAND_MAX_ID_BOOKS = "max_id_of_books";
	public static final String COMMAND_NAME_BOOK = "title";
}
