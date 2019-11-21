package com.liuhe.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liuhe.beans.Article;

public interface ArticleService {

	//获取最新文章
	List<Article> getNewArticles(int i);
	//获取热门文章
	PageInfo<Article> hotlist(int page);
	
	//根据文章id获取文章的内容
	Article getById(Integer id);
	//根据频道或者分类获取文章
	PageInfo<Article> listByCat(int chnId, int categoryId, int page);

	
	
}
