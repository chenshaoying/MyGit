package com.blackcat.designpatterns.factory;

public class CakeStore {
	private CakeFactory factory;
	private enum FactoryName{Alibaba, Tencent, Baidu};
	
	public CakeStore(String factoryName) {
		if(FactoryName.Alibaba.name().equals(factoryName)) {
			this.factory = new AlibabaCakeFactory();
		} else if(FactoryName.Tencent.name().equals(factoryName)) {
			this.factory = new TencentCakeFactory();
		} else if(FactoryName.Baidu.name().equals(factoryName)) {
			this.factory = new BaiduCakeFactory();
		} else {
			this.factory = new CakeFactory() {
				
				@Override
				public Cake createCake() {
					return new Cake() {

						@Override
						public String getName() {
							System.out.println("默认出品");
							return "default";
						}
						
					};
				}
				
			};
		}
	}
	
	public void prepareCake() {
		factory.createCake().getName();
	}

}
