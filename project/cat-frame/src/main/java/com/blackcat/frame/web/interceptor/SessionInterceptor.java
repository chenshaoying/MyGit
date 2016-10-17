package com.blackcat.frame.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blackcat.frame.core.enums.SessionEnum;

public class SessionInterceptor implements HandlerInterceptor  {
	private static final Logger log = LoggerFactory.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		HttpSession session = request.getSession(false);
		if(session == null) {
			log.debug("Session not exists or time out.");
			return false;
		}
		Object isLogin = session.getAttribute(SessionEnum.IS_LOGIN.name());
		if(isLogin == null || ! ((boolean) isLogin)) {
			log.debug("User has not logined.");			
			return false;
		}		
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
