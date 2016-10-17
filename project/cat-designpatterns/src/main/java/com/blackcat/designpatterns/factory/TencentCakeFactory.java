package com.blackcat.designpatterns.factory;

public class TencentCakeFactory implements CakeFactory {

	@Override
	public Cake createCake() {
		return new Cake() {

			@Override
			public String getName() {
				System.out.println("腾讯出品");
				return "腾讯出品";
			}
			
		};
	}
}
