package com.liuhe.service;

import java.util.List;

import com.liuhe.beans.Category;

public interface CategoryService {

	List<Category> listByChannelId(int chnId);

}
