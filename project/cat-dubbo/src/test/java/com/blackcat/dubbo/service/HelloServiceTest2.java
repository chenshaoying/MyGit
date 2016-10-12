package com.blackcat.dubbo.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceTest2 {
	public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
        HelloService hello = (HelloService) context.getBean("demoService");
        System.out.println(hello.hello());
        System.in.read(); // 按任意键退出
    }
}
