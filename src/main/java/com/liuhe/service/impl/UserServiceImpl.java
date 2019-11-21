package com.liuhe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.visitor.functions.Substring;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhe.beans.User;
import com.liuhe.common.ConstantClass;
import com.liuhe.common.Md5;
import com.liuhe.dao.UserMapper;
import com.liuhe.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;
	
	@Override
	public PageInfo list(String name,Integer pageNum) {
		PageHelper.startPage(pageNum, ConstantClass.PAGE_SIZE);
		List<User> list = mapper.list(name);
		PageInfo info = new PageInfo(list);
		return info;
	}

	@Override
	public User getById(Integer userId) {
		// TODO Auto-generated method stub
		return mapper.getById(userId);
	}

	@Override
	public int updateStatus(Integer userId, int status) {
		// TODO Auto-generated method stub
		return mapper.updateStatus(userId, status);
	}

	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return mapper.findByUserName(username);
	}

	@Override
	public int register(User user) {
		//user.setPassword(Md5.password(user.getPassword(),user.getUsername.substring(0,2)));
		return 0;
	}

	@Override
	public User login(User user) {
		
		User loginUser = findByName(user.getUsername());
		if(loginUser==null)
			return null;
			String pwdSaltMd5 = Md5.password(user.getPassword(),user.getUsername());
		if(pwdSaltMd5.equals(loginUser.getPassword())){
			return loginUser;
		}
		else{
			//登录失败
			return null;
		}
		
		
	}

	
	
}
