package com.blackcat.frame.web.service;

import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public interface IWebService {
	
	//加入WebParam注解，以保证xml文件中参数名字的正确性
	String sayHi(@WebParam(name="text") String text); 
}
