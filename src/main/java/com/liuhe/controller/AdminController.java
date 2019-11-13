package com.liuhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.liuhe.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private UserService service;
	
	@RequestMapping("index")
	public String index(){
		return "admin/index";
	}
	
	@RequestMapping("articles")
	public String articles(){
		
		return "admin/article/list";
		
	}
	
	@RequestMapping("users")
	public String users(@RequestParam(defaultValue="")String name,@RequestParam(defaultValue="1")Integer pageNum,Model m){
		PageInfo info = service.list(name, pageNum);
		m.addAttribute("info", info);
		m.addAttribute("name", name);
		return "admin/user/list";
		
	}
	
}
