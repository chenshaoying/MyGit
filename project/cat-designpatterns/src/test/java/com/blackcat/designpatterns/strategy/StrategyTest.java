package com.blackcat.designpatterns.strategy;

import java.math.BigDecimal;

import org.junit.Test;

public class StrategyTest {
	@Test
	public void test() {
		Goods goods = new Goods("Iphone", new BigDecimal(5300));
		Spend normal = new Spend(new NormalGuest(), goods);
		Spend vip = new Spend(new VIPGuest(), goods);
		
		normal.spend();
		vip.spend();
	}
}
