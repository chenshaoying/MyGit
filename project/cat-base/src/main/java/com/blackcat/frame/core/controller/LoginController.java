package com.blackcat.frame.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.blackcat.frame.core.model.SysUser;
import com.blackcat.frame.core.service.SysUserService;

@Controller
@SessionAttributes("user")  
public class LoginController {
	
	@Autowired 
	private SysUserService sysUserService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {		
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(SysUser user,Model model) {
		if(sysUserService.validateUser(user)) {
			user = sysUserService.queryUserDetail(user.getUserid());
			model.addAttribute("user", user);
			return "main";
		} 
		model.addAttribute("message", "Hello World!");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute("user") SysUser user ) {
		return user.getUserna();
	}
	
}
