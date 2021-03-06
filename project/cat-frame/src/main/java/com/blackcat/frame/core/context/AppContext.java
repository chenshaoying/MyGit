package com.blackcat.frame.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Description: 程序上下文
 * @author: Darren Chan
 */
public class AppContext implements ApplicationContextAware {
	private static ApplicationContext ctx;
	
	public static ApplicationContext getContext() {
		checkApplicationContext();
		return ctx;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		AppContext.ctx = applicationContext;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return ctx.getBean(clazz);
	}
	public static Object getBeanByName(String beanName) {
		Object bean = ctx.getBean(beanName);
		if(bean == null) {
			throw new NullPointerException("no such bean:" + beanName);
		}
		return ctx.getBean(beanName);
	}
	
	private static void checkApplicationContext() {
		if(ctx == null) {
			throw new IllegalStateException("no applictionContext.");
		}
    }
}
