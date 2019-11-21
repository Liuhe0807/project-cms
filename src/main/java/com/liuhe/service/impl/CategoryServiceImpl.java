package com.liuhe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhe.beans.Category;
import com.liuhe.dao.CategoryMapper;
import com.liuhe.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryMapper mapper;
	
	@Override
	public List<Category> listByChannelId(int chnId) {
		// TODO Auto-generated method stub
		return mapper.listByChannelId(chnId);
	}

	
	
}
