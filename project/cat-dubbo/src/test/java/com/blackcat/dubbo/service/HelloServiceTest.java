package com.blackcat.dubbo.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceTest {
	public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider.xml"});
        context.start();
 
        System.in.read(); // 按任意键退出
    }
}
