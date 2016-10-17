package com.blackcat.designpatterns.observer;

import java.math.BigDecimal;

public class ObserverTest {
	
	public static void main(String[] args) {
		Iphone7Subject s = new Iphone7Subject(5, new BigDecimal(5300));
		
		Observer jd = new JDObserver();
		Observer cu = new CustomerObserver();
		
		s.register(jd);
		s.register(cu);
		
		s.setRemains(4);
	}
}
