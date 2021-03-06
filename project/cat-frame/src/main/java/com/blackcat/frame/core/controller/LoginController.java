package com.blackcat.frame.core.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blackcat.frame.core.enums.SessionEnum;
import com.blackcat.frame.core.model.SysMenu;
import com.blackcat.frame.core.model.SysUser;
import com.blackcat.frame.core.service.SysMenuService;
import com.blackcat.frame.core.service.SysUserService;
import com.blackcat.frame.core.utils.DictUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@Controller
public class LoginController {
	
	@Autowired 
	private SysUserService sysUserService;
	@Autowired 
	private SysMenuService sysMenuService;
	@Autowired  
    private Producer captchaProducer;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		SysUser user = new SysUser();
		user.setGender("U");
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(SysUser user,Model model,HttpSession httpSession) {
     	
		if(sysUserService.validateUser(user)) {
			httpSession.setAttribute(SessionEnum.IS_LOGIN.name(), true);
			httpSession.setAttribute(SessionEnum.USER.name(), user);
			httpSession.setAttribute(SessionEnum.LAST_LOGIN_TIME.name(), System.currentTimeMillis());
        	//获取menu
        	List<SysMenu> menus = sysMenuService.getMenus(user.getUserid());
        	model.addAttribute("menus", menus);
    		return "main";
		}
        return "index";  
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession httpSession) {
		//httpSession.
        Subject subject = SecurityUtils.getSubject(); 
        subject.logout();
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
	
	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
	public String unauthorized(Model model) {
		/*model.addAttribute("user", new SysUser());
		model.addAttribute("genderList", DictUtil.getDict("common", "gender", true));*/
		return "unauthorized";
	}
	
	@RequestMapping(value = "/getKaptchaImage/{kaptcha_type}", method = RequestMethod.GET)
	 public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response,@PathVariable("kaptcha_type") String kaptcha_type) throws Exception {  
           
        response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/jpeg");  
         
        HttpSession session = request.getSession();      
        String capText = captchaProducer.createText();  
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY + "_" + kaptcha_type, capText);  
         
        BufferedImage bi = captchaProducer.createImage(capText);  
        ServletOutputStream out = response.getOutputStream();  
        ImageIO.write(bi, "jpg", out);  
        try {  
            out.flush();  
        } finally {  
            out.close();  
        }  
        return null;  
    }  
	
	@ResponseBody
	@RequestMapping(value = "/getKaptchaImage/getValue/{kaptcha_type}", method = RequestMethod.GET)
	public String getKaptchaValue(HttpSession session,@PathVariable("kaptcha_type") String kaptcha_type) {
		System.out.print((String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY + "_" + kaptcha_type));
		return (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY + "_" + kaptcha_type);  
	}
	@ResponseBody
	@RequestMapping(value = "/login/addUser", method = RequestMethod.POST)
	public String register(SysUser user) {
		sysUserService.addUser(user);
		return "新增成功";
	}
	
	@ModelAttribute
	public void getDicts(Model model) {
		model.addAttribute("genderList", DictUtil.getDict("common", "gender", false));

	}
}
