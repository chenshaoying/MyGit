package com.blackcat.frame.web.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebExceptionHandler implements HandlerExceptionResolver {  
	private static final Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,  
            Exception ex) {  
    	//TODO 此处处理页面提交异常，是否打印待定
    	if(log.isDebugEnabled()) {
    		log.error(ex.getMessage());    		
    	}
        Map<String, Object> model = new HashMap<String, Object>();          
        
        // Convert object to JSON string  
        ObjectMapper mapper = new ObjectMapper();  
        String Json = "";
        Map<String,String> m = new HashMap<String,String>();
        m.put("error", ex.getMessage());
		try {
			Json = mapper.writeValueAsString(m);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}  
        model.put("errorMsg", Json); 
      //  model.put("", ex.);
        //判断是否为ajax请求，requestType为null时为普通请求  
        //String requestType = request.getHeader("X-Requested-With");
        // 根据不同错误转向不同页面  
        /*if(ex instanceof BusinessException) {  
            return new ModelAndView("error-business", model);  
        }else if(ex instanceof ParameterException) {  
            return new ModelAndView("error-parameter", model);  
        } else {  
            return new ModelAndView("error", model);  
        }*/  
        return new ModelAndView("error", model);  
    }  
}  