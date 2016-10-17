package com.blackcat.designpatterns.factory;

public class AlibabaCakeFactory implements CakeFactory {

	@Override
	public Cake createCake() {
		return new Cake() {

			@Override
			public String getName() {
				System.out.println("阿里出品");
				return "阿里出品";
			}
			
		};
	}
}
