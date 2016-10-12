package com.blackcat.frame.web.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class WebServiceClient {
	
	public static void main(String[] args) {
		JaxWsProxyFactoryBean soapFactoryBean = new JaxWsProxyFactoryBean();

		soapFactoryBean.setAddress("http://localhost:8080/WSCXF/IWebService");

		soapFactoryBean.setServiceClass(IWebService.class);

		Object o = soapFactoryBean.create();

		IWebService webService = (IWebService)o;
		System.out.println("---------------client received：" + webService.sayHi("111111"));
	}
}
