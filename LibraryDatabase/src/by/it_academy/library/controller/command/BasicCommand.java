package by.it_academy.library.controller.command;

import java.util.Map;

public interface BasicCommand {
	void performAction(Map<String, Object> userData);
}
