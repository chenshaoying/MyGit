package com.blackcat.frame.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralProxy implements InvocationHandler {
	private static final Logger log = LoggerFactory.getLogger(GeneralProxy.class);
	private Object target;
	
	  /** 
     * 绑定委托对象并返回一个代理类 
     * @param target 
     * @return 
     */  
    public Object bind(Object target) {  
        this.target = target;  
        //取得代理对象  
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)  
    } 
    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("Proxy start");
		Object result = method.invoke(target, args);
		log.info("proxy end");
		return result;
	}
	
}
