package com.liuhe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhe.beans.Link;
import com.liuhe.dao.LinkMapper;
import com.liuhe.service.LinkService;
@Service
public class LinkServiceImpl implements LinkService{

	@Autowired
	LinkMapper linkMapper;

	@Override
	public void add(Link link) {
		linkMapper.add(link);
		
	}

	@Override
	public PageInfo getLinkList(Integer pageNum) {
		PageHelper.startPage(pageNum, 3);
		List list = linkMapper.getLinkList(pageNum);
		PageInfo info = new PageInfo(list);
		return info;
	}

	
	
	
	
}
