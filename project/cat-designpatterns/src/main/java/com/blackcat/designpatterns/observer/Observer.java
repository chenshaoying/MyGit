package com.blackcat.designpatterns.observer;

import java.math.BigDecimal;

public interface Observer {
	
	public void update(int remains, BigDecimal price);

}
