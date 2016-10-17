package com.blackcat.designpatterns.observer;

import java.math.BigDecimal;

public class CustomerObserver implements Observer{

	@Override
	public void update(int remains, BigDecimal price) {
		// TODO Auto-generated method stub
		System.out.println("JD observer：" + remains + ":" + price);
	}

}
