package com.blackcat.designpattern.command;

public class RemoteController {
	
	public void clickButton(Command command) {
		command.execute();
	}
	
	public static void main(String[] args) {
		RemoteController controller = new RemoteController();
		controller.clickButton(new TurnOnCommand());
		controller.clickButton(new TurnOffCommand());
	}
}
