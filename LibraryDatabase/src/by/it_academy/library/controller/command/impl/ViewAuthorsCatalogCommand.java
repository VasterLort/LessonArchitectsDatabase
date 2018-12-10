package by.it_academy.library.controller.command.impl;

import java.util.Map;

import by.it_academy.library.controller.command.BasicCommand;
import by.it_academy.library.entity.AuthorCatalog;
import by.it_academy.library.service.AllCatalogService;
import by.it_academy.library.service.impl.RegularServiceImpl;

public class ViewAuthorsCatalogCommand implements BasicCommand{
	private AllCatalogService authorCatalogService;
	
	@Override
	public void performAction(Map<String, Object> userData) {
		authorCatalogService = new RegularServiceImpl();
		AuthorCatalog catalog = authorCatalogService.authorCatalog();
		System.out.println(catalog);
	}

}
