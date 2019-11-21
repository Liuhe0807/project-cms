package com.liuhe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhe.beans.Article;
import com.liuhe.common.ConstantClass;
import com.liuhe.dao.ArticleMapper;
import com.liuhe.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleMapper mapper;

	@Override
	public List<Article> getNewArticles(int i) {
		// TODO Auto-generated method stub
		return mapper.newList(i);
	}

	@Override
	public PageInfo<Article> hotlist(int page) {
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		List<Article> list = mapper.hotList();
		PageInfo info = new PageInfo(list);
		return info;
	}

	@Override
	public Article getById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getById(id);
	}

	@Override
	public PageInfo<Article> listByCat(int chnId, int categoryId, int page) {
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		List<Article> list = mapper.listByCat(chnId,categoryId);
		PageInfo info = new PageInfo(list);
		return info;
	}
}
