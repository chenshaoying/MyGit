package com.blackcat.designpatterns.strategy;

import java.math.BigDecimal;

public class VIPGuest implements Guest {

	@Override
	public BigDecimal getDiscount() {
        return BigDecimal.valueOf(0.5);
	}

	@Override
	public String getName() {
		return "VIP guest";
	}
}
