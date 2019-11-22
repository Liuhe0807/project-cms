package com.liuhe.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liuhe.beans.Article;
import com.liuhe.beans.User;

public interface UserService {

	PageInfo list(String name,Integer pageNum);
	
	User getById(Integer userId);
	//解禁和封禁
	int updateStatus(Integer userId,int status);
	//根据用户名查找用户
	User findByName(String username);
	//注册用户
	int register(User user);

	User login(User user);

	
	
	
}
