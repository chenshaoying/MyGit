package com.blackcat.designpatterns.decorator;

public class SaltSoup implements Soup{
	private Soup decorator;
	
	public SaltSoup(Soup decorator) {
		this.decorator = decorator;
	}
	
	@Override
	public String recipes() {
		// TODO Auto-generated method stub
		String recipe = "salt," + decorator.recipes();
		System.out.println(recipe);
		return recipe;
	}
	
	 
}
