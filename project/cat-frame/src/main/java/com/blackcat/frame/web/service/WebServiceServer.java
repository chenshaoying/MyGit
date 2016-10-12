package com.blackcat.frame.web.service;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class WebServiceServer {
	
	public static void main(String[] args) {
		IWebService impl = new CxfWebServiceImpl();

		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();

		factoryBean.setAddress("http://localhost:8080/WSCXF/IWebService");

		factoryBean.setServiceClass(IWebService.class);//接口类

		factoryBean.setServiceBean(impl);

		factoryBean.create();

		System.out.println("WS发布成功！");
	}
}
