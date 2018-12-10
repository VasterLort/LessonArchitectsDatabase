package by.it_academy.library.controller.console.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static by.it_academy.library.controller.util.ControllerConstantStorage.*;

public class SimpleConsoleView {
	private static Map<String, Object> userInput = new HashMap<>();
	
	public static void showBasicMenu(){
		System.out.println();
		System.out.println("1 - view books catalog");
		System.out.println("2 - view authors catalog");
		System.out.println("3 - view single catalog row");
		System.out.println("4 - find books by author");
		System.out.println("5 - add new book");
	}
	
	public static Map<String, Object> readUserInput(){
		int item = readMenuItem();
		getInputData(item);
				
		return userInput;
	}
	
	private static void getInputData(int menuItem){
		switch(menuItem){
		case 1:
			userInput.put(COMMAND_USER_ACTION, COMMAND_LIBRARY_VIEW);
			break;
		case 2:
			userInput.put(COMMAND_USER_ACTION, COMMAND_AUTHOR_VIEW);
			break;
		case 3:
			userInput.put(COMMAND_USER_ACTION, COMMAND_SINGLE_ROW); 
			break;
		case 4:
			userInput.put(COMMAND_USER_ACTION, COMMAND_FIND_BOOK);
			break;
		case 5:
			userInput.put(COMMAND_USER_ACTION, COMMAND_ADD_BOOK);
			break;
		}
	}
	private static int readMenuItem(){
		return inputInt();
	}
	
	private static int inputInt(){
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		try{
			num = Integer.parseInt(read.readLine());
			System.out.println();
		}catch(IOException e){e.printStackTrace();}
		
		return num;
	}
}
