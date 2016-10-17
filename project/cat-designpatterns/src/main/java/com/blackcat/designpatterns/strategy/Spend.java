package com.blackcat.designpatterns.strategy;

import java.math.BigDecimal;

public class Spend {
	private Guest guest;
	private Goods goods;
	
	public Spend(Guest guest, Goods goods) {
		this.guest = guest;
		this.goods = goods;
	}
	
	public BigDecimal spend() {
		BigDecimal realPrice = guest.getDiscount().multiply(goods.getPrice());
		System.out.println(guest.getName()+ " spends: " + realPrice);
		return realPrice;
	}
}

class Goods {
	private String name;
	private BigDecimal price;
	
	public Goods(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
