package com.blackcat.designpatterns.observer;

import java.math.BigDecimal;

public class JDObserver implements Observer{

	@Override
	public void update(int remains, BigDecimal price) {
		// TODO Auto-generated method stub
		System.out.println("Customer observer：" + remains + ":" + price);
	}

}
