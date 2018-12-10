package by.it_academy.library.controller.command.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import by.it_academy.library.controller.command.BasicCommand;
import by.it_academy.library.entity.BookCatalog;
import by.it_academy.library.service.AllCatalogService;
import by.it_academy.library.service.impl.RegularServiceImpl;

public class FindBooksByAuthor implements BasicCommand{
	private AllCatalogService authorCatalogService;
	
	@Override
	public void performAction(Map<String, Object> userData) {
		System.out.print("Id author: ");
		int idAuthor = inputInt();
		authorCatalogService = new RegularServiceImpl();
		BookCatalog catalog = authorCatalogService.listBooksOfAuthor(idAuthor);
		System.out.println();
		System.out.println(catalog);
	}
	
	private static int inputInt() {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		try {
			num = Integer.parseInt(read.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return num;
	}
}
