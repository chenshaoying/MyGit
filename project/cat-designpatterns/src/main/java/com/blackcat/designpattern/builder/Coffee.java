package com.blackcat.designpattern.builder;

public class Coffee {
	private String name;
	private boolean milk;
	private boolean sugar;
	
	//私有化构造器，只能使用builder进行构造
	private Coffee(String name, boolean milk, boolean sugar) {
		this.name = name;
		this.milk = milk;
		this.sugar = sugar;
	}
	
	//删除set方法，通过builder进行赋值
	public String getName() {
		return name;
	}

	public boolean isMilk() {
		return milk;
	}

	public boolean isSugar() {
		return sugar;
	}

	public static class CoffeeBuilder {
		private final String name;
		private boolean milk;
		private boolean sugar;
		
		//使用builder适用于具有多个field的类的实例化，并且可对输入参数进行验证
		public CoffeeBuilder(String name) {
			if(name == null || "".equals(name.trim())) {
				throw new IllegalArgumentException("coffee name can not be null or empty!");
			}
			this.name = name;
		}
		
		public CoffeeBuilder withSugar(boolean sugar) {
			this.sugar = sugar;
			return this;
		}
		public CoffeeBuilder withMilk(boolean milk) {
			this.milk = milk;
			return this;
		}
		
		public Coffee build() {		
			return new Coffee(name, milk, sugar);
		}
	}
}
