package by.it_academy.library.controller.command.impl;

import java.util.Map;

import by.it_academy.library.controller.command.BasicCommand;

public class DefaultCommand implements BasicCommand{

	@Override
	public void performAction(Map<String, Object> userData) {
		System.out.println("Incorrect user input");
	}

}
