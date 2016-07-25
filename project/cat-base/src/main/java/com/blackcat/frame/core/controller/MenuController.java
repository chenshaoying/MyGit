package com.blackcat.frame.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blackcat.frame.core.model.SysUser;
import com.blackcat.frame.core.utils.DictUtil;

@Controller
public class MenuController {
	
	@RequestMapping(value = "/test/menu", method = RequestMethod.GET)
	public String forward(Model model) {
		model.addAttribute("user", new SysUser());
		model.addAttribute("genderList", DictUtil.getDict("common", "gender", false));
		return "main3";
	}
}
