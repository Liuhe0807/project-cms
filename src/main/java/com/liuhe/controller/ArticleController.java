package com.liuhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liuhe.beans.Article;
import com.liuhe.common.CmsAssert;
import com.liuhe.service.ArticleService;
@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	ArticleService service;
	
	@RequestMapping("showdetail")
	public String showDetail(Model m,Integer id){
		Article articles = service.getById(id);
		CmsAssert.AssertTrue(articles!=null, "文章不存在");
		m.addAttribute("articles", articles);
		return "article/detail";
		
	}
	
	
}
