package by.it_academy.library.controller.command;

import by.it_academy.library.controller.command.impl.AddNewBooks;
import by.it_academy.library.controller.command.impl.FindBooksByAuthor;
import by.it_academy.library.controller.command.impl.ViewAuthorsCatalogCommand;
import by.it_academy.library.controller.command.impl.ViewBookCatalogCommand;
import by.it_academy.library.controller.command.impl.ViewSingleCatalogRowCommand;

import static by.it_academy.library.controller.util.ControllerConstantStorage.*;

public class CommandManager {
	private static BasicCommand command;
	public static BasicCommand defineCommand(String action){
		switch(action){
		case COMMAND_LIBRARY_VIEW:
			command = new ViewBookCatalogCommand();
			break;
		case COMMAND_AUTHOR_VIEW:
			command = new ViewAuthorsCatalogCommand();
			break;
		case COMMAND_SINGLE_ROW:
			command = new ViewSingleCatalogRowCommand();
			break;
		case COMMAND_FIND_BOOK:
			command = new FindBooksByAuthor();
			break;
		case COMMAND_ADD_BOOK:
			command = new AddNewBooks();
			break;
		}
		
		return command;
	}
}
