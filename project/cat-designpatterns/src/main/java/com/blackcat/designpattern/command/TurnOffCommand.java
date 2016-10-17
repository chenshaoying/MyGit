package com.blackcat.designpattern.command;

public class TurnOffCommand implements Command {

	@Override
	public void execute() {
		
		System.out.println("lights turn off");
	}
	
	
}
