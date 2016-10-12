package com.blackcat.frame.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blackcat.frame.core.model.SysUser;
@Controller
public class RestController {
	
	@ResponseBody
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public SysUser register(@PathVariable int id) {
		SysUser user = new SysUser();
		user.setUserid(id + "");
		user.setUserna("XX");
		return user;
	}
	
	
}
