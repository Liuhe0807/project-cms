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
	//文章列表
	PageInfo<Article> listByUser(int page, Integer id);
	//删除
	int delete(int id);
	//检查是否存在
	Article checkExist(int id);
	//根据状态查询文章
	PageInfo<Article> getPageList(int status, Integer page);
	//获取文章详情  不考虑文章的状态
	Article getDetailById(int id);
	//审核文章
	int apply(int id, int status);
	//设置热门与否
	int setHot(int id, int status);
	
	//添加文章 
	int add(Article article);

	//修改文章
	int update(Article article);
	
	//收藏文章
	int favorite(Integer userId, int articleId);
	
}