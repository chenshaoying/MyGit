package com.blackcat.frame.core.proxy;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private static final Logger log = LoggerFactory.getLogger(CglibProxy.class);

	private Object target;
	
	/** 
     * 创建代理对象 
     *  
     * @param target 
     * @return 
     */  
    public Object getInstance(Object target) {  
        this.target = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.target.getClass());  
        // 回调方法  
        enhancer.setCallback(this);  
        // 创建代理对象  
        return enhancer.create();  
    } 
    
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		log.info("Proxy start");
        Object result = proxy.invokeSuper(obj, args); 
		log.info("proxy end");
		return result;
	}

}
