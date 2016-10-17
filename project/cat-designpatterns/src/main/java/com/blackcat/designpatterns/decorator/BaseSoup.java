package com.blackcat.designpatterns.decorator;

public class BaseSoup implements Soup {
	
	private String recipe;
	public BaseSoup() {
		recipe = "water";
	}
	@Override
	public String recipes() {
		// TODO Auto-generated method stub
		System.out.println(recipe);
		return recipe;
	}
	
	
}
