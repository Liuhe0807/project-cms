package com.liuhe.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhe.beans.User;
import com.liuhe.common.CmsAssert;
import com.liuhe.common.ConstantClass;
import com.liuhe.service.ArticleService;
import com.liuhe.service.ChannelService;
import com.liuhe.service.UserService;



@Controller
@RequestMapping("user")
public class UserController {
	
	Logger log = Logger.getLogger(UserController.class);
	
	
	@Value("${upload.path}")
	String updloadPath;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ArticleService articleService;
	
	
	@Autowired
	ChannelService channelService;

	private SimpleDateFormat dateFormat;
	
	@Autowired
	private UserService service;
	//  httppxxxx://user/hello
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String tet(HttpServletRequest request) {
		request.setAttribute("info", "hello");
		return "user/test";
	}
	
	
	//跳转注册页面
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(Model m){
		
		return "user/register";
		
	}

	//处理用户提交的注册的数据
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(Model m,User user){
		//用户名是否存在
		User existUser = service.findByName(user.getUsername());
		CmsAssert.AssertTrue(existUser!=null, "该用户已经存在");
		
		int result = service.register(user);
		CmsAssert.AssertTrue(result>0, "用户注册失败，请稍后再试");
		
		return "redirect:/user/login";
		
	}
	
	//跳转登录页面
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model m){
		
		return "user/login";
		
	}
	
	//处理用户提交的注册的数据
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String login(HttpServletRequest request,User user){
		User loginUser = service.login(user);
		//用户存在登录成功
		if(loginUser!=null){
		request.getSession().setAttribute(ConstantClass.USER_KEY, loginUser);
			return "redirect:/user/home";
		}
		else{
			request.setAttribute("user", user);
			return "user/login";
		}
		
		
		
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute(ConstantClass.USER_KEY);
		return "redirect:/";
		
	}
	
	
	@RequestMapping("checkname")
	@ResponseBody
	public boolean checkname(String username){
		return null==service.findByName(username);
	}
}
