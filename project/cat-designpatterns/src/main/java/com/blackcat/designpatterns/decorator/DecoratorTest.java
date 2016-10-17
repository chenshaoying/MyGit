package com.blackcat.designpatterns.decorator;

import org.junit.Test;

public class DecoratorTest {
	
	@Test
	public void test() {
		Soup base = new BaseSoup();
		base.recipes();
		
		System.out.println("___________");
		
		Soup salt = new SaltSoup(base);
		salt.recipes();
	}
}
