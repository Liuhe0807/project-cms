package com.liuhe.dao;

import java.util.List;

import com.liuhe.beans.Category;

public interface CategoryMapper {

	//获取分类
	List<Category> listByChannelId(int chnId);

	
	
}
