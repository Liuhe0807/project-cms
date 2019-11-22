package com.liuhe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhe.beans.Article;
import com.liuhe.common.CmsAssert;
import com.liuhe.service.ArticleService;
import com.liuhe.service.CategoryService;
import com.liuhe.common.MsgResult;
import com.liuhe.beans.Category;
@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	ArticleService service;
	
	@Autowired
	CategoryService catService;
	
	
	@RequestMapping("showdetail")
	public String showDetail(Model m,Integer id){
		Article articles = service.getById(id);
		CmsAssert.AssertTrueHtml(articles!=null, "文章不存在");
		m.addAttribute("articles", articles);
		return "article/detail";
		
	}
	//分类
	@RequestMapping("getCategoryByChannel")
	@ResponseBody
	public MsgResult getCategoryByChannel(int chnId) {
		//List<Category> categories =  
		List<Category> categories = catService.listByChannelId(chnId);
		return new MsgResult(1, "",  categories);
		
	}
}
