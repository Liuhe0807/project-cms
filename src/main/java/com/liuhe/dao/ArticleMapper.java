package com.liuhe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhe.beans.Article;

public interface ArticleMapper {

	//获取最新文章 @param i 获取个数
	List<Article>  newList(int i);
	//获取热门文章
	List<Article> hotList();
	
	//获取文章
	Article getById(Integer id);
	//根据频道获取文章
	List<Article> listByCat(@Param("chnId")int chnId, @Param("categoryId")int categoryId);
	
}
