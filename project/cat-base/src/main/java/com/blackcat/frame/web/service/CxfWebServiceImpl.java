package com.blackcat.frame.web.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.blackcat.frame.web.service.IWebService", serviceName = "IWebService")
public class CxfWebServiceImpl implements IWebService{

	@Override
	public String sayHi(String text) {
		System.out.println("------------------------------------------------------------------" + text);
        return "Hello " + text;  
	}

	

	
	
}
