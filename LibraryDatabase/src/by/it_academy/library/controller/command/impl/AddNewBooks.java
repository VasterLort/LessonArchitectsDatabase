package by.it_academy.library.controller.command.impl;

import java.util.Map;

import by.it_academy.library.controller.command.BasicCommand;
import by.it_academy.library.service.AllCatalogService;
import by.it_academy.library.service.impl.RegularServiceImpl;

public class AddNewBooks implements BasicCommand{
private AllCatalogService catalogService;
	
	@Override
	public void performAction(Map<String, Object> userData) {
		catalogService = new RegularServiceImpl();
		catalogService.addInfo();
	}

}
