package com.blackcat.designpatterns.factory;

import org.junit.Test;

public class FactoryTest {
	
	@Test
	public void test() {
		CakeStore ali = new CakeStore("Alibaba");
		ali.prepareCake();
		
		CakeStore tencent = new CakeStore("Tencent");
		tencent.prepareCake();
		
		CakeStore baidu = new CakeStore("Baidu");
		baidu.prepareCake();
		
		CakeStore dd = new CakeStore("default");
		dd.prepareCake();
	}
}
