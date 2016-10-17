package com.blackcat.designpatterns.strategy;

import java.math.BigDecimal;

public class NormalGuest implements Guest {

	@Override
	public BigDecimal getDiscount() {
        return BigDecimal.ONE;
	}

	@Override
	public String getName() {
		return "Normal guest";
	}
}
