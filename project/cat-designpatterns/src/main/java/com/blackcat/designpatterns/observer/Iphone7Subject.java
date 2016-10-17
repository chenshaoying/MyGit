package com.blackcat.designpatterns.observer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Iphone7Subject implements Subject{
	private List<Observer> obs;
	private BigDecimal price;
	private int remains;
	
	public Iphone7Subject(int remains, BigDecimal price) {
		obs = Collections.synchronizedList(new ArrayList<Observer>());
		this.price = price;
		this.remains = remains;
	}
	
	@Override
	public void register(Observer ob) {
		synchronized(obs) {
			if(!obs.contains(ob)) {
				obs.add(ob);
				ob.update(remains, price);
			}			
		}
	}

	@Override
	public void notifyObservers() {
		for(Observer ob : obs) {
			ob.update(remains, price);
		}
	}

	@Override
	public void remove(Observer ob) {
		if(obs.contains(ob)) {
			obs.remove(ob);
		}
	}

	public void change(BigDecimal price, int remains) {
		this.price = price;
		this.remains = remains;
		notifyObservers();
	}
	
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		if(!this.price.equals(price)) {
			this.price = price;
			change(this.price, remains);
		}
	}

	public int getRemains() {
		return remains;
	}

	public void setRemains(int remains) {
		if(this.remains != remains) {
			this.remains = remains;
			change(price, this.remains);			
		}

	}

	
}
