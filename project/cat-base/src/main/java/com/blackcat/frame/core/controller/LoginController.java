package com.blackcat.frame.core.controller;

import java.util.List;

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
import com.blackcat.frame.core.utils.DictUtil;

@Controller
@SessionAttributes("user")  
public class LoginController {
	
	@Autowired 
	private SysUserService sysUserService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("user", new SysUser());
		model.addAttribute("genderList", DictUtil.getDict("common", "gender", true));
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
		model.addAttribute("genderList", DictUtil.getDict("common", "gender", true));
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute("user") SysUser user ) {
		return user.getUserna();
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryUserList", method = RequestMethod.GET)
	public List<SysUser> queryUserList(SysUser user ) {
		return sysUserService.getUsersSelective(user);
	}
}
