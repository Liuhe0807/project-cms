package com.liuhe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.liuhe.beans.Link;
import com.liuhe.service.LinkService;

@Controller
@RequestMapping("link")
public class LinkController {

	@Autowired
	LinkService linkService;
	
	@RequestMapping("list")
	public String add(Model m,@RequestParam(defaultValue="1")Integer pageNum){
		PageInfo info = linkService.getLinkList(pageNum);
		m.addAttribute("info", info);
		
		return "/link/list";
	}

	@RequestMapping("add")
	public String add(HttpServletRequest request,@Valid@ModelAttribute("link") Link link,
			BindingResult result){
		//有错误 还在原来的页面
		if(result.hasErrors()){
			return "link/add";
		}
		linkService.add(link);
		//没有错误跳转到列表页面
		return "redirect:list";
	}
	
}
