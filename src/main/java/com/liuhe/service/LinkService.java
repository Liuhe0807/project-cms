package com.liuhe.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liuhe.beans.Link;

public interface LinkService {

	PageInfo getLinkList(Integer pageNum);
	
	void add(Link link);

	
}
