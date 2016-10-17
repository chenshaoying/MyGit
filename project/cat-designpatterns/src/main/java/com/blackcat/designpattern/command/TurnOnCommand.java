package com.blackcat.designpattern.command;

public class TurnOnCommand implements Command {

	@Override
	public void execute() {
		
		System.out.println("lights turn on");
	}
	
	
}
