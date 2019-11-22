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
	ArticleMapper articleMapper;

	@Override
	public List<Article> getNewArticles(int i) {
		// TODO Auto-generated method stub
		return articleMapper.newList(i);
	}

	@Override
	public PageInfo<Article> hotlist(int page) {
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		List<Article> list = articleMapper.hotList();
		PageInfo info = new PageInfo(list);
		return info;
	}

	@Override
	public Article getById(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.getById(id);
	}

	@Override
	public PageInfo<Article> listByCat(int chnId, int categoryId, int page) {
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		List<Article> list = articleMapper.listByCat(chnId,categoryId);
		PageInfo info = new PageInfo(list);
		return info;
	}

	//列表
	@Override
	public PageInfo<Article> listByUser(int page, Integer userId) {
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.listByUser(userId));
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return articleMapper.delete(id);
	}

	@Override
	public Article checkExist(int id) {
		// TODO Auto-generated method stub
		return articleMapper.checkExist(id);
	}

	@Override
	public PageInfo getPageList(int status, Integer page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		return new PageInfo(articleMapper.listByStatus(status));
	}

	@Override
	public Article getDetailById(int id) {
		// TODO Auto-generated method stub
		return  articleMapper.getDetailById(id);
	}

	@Override
	public int add(Article article) {
		// TODO Auto-generated method stub
		System.out.println("=================="+article+"==========================");
		return articleMapper.add(article);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}

	@Override
	public int apply(int id, int status) {
		// TODO Auto-generated method stub
		return articleMapper.apply(id, status);
	}

	@Override
	public int setHot(int id, int status) {
		// TODO Auto-generated method stub
		return articleMapper.setHot(id, status);
	}

	
}
