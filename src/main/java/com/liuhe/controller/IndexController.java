package com.liuhe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.liuhe.beans.Article;
import com.liuhe.beans.Category;
import com.liuhe.beans.Channel;
import com.liuhe.service.ArticleService;
import com.liuhe.service.CategoryService;
import com.liuhe.service.ChannelService;

@Controller
public class IndexController {

	@Autowired
	private ChannelService service;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ArticleService articleService;
	
	//查看某一个频道 chnId：频道id page：文章页码
	@RequestMapping("channel")
	public String channel(Model m,@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="0")int categoryId,
			@RequestParam(defaultValue="1")int chnId){
		//获取所有的频道
		List<Channel> channels = service.list();
		m.addAttribute("channels", channels);
		
		//获取这个频道下的所有的分类
		List<Category> categories = categoryService.listByChannelId(chnId);
		m.addAttribute("categoryId", categoryId);
		m.addAttribute("categories", categories);
		
		PageInfo<Article> article =  articleService.listByCat(chnId,categoryId,page);
		List<Article> list = article.getList();
		//System.out.println("========="+list);
		m.addAttribute("article", article);
		m.addAttribute("chnId", chnId);
		return "channelIndex";
	}
	
	@RequestMapping(value={"index","/"})
	public String index(Model m,@RequestParam(defaultValue="1")int page){
		//获取所有的频道
		List<Channel> channels = service.list();
		m.addAttribute("channels", channels);
		
		PageInfo<Article> hotList =  articleService.hotlist(page);
		
		List<Article> newArticle = articleService.getNewArticles(5);
		
		m.addAttribute("hotList", hotList);
		m.addAttribute("newArticle", newArticle);
		return "index";
	}
	
}
