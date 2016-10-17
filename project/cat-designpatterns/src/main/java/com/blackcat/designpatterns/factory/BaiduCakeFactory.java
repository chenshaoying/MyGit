package com.blackcat.designpatterns.factory;

public class BaiduCakeFactory implements CakeFactory {

	@Override
	public Cake createCake() {
		return new Cake() {

			@Override
			public String getName() {
				System.out.println("百度出品");
				return "百度出品";
			}
			
		};
	}

}
