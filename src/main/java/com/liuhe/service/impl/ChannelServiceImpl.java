package com.liuhe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhe.beans.Channel;
import com.liuhe.dao.ChannelMapper;
import com.liuhe.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService{

	@Autowired
	private ChannelMapper mapper;

	@Override
	public List<Channel> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}
	
	
	
}
