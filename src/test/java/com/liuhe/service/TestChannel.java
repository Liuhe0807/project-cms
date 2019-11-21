package com.liuhe.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.liuhe.beans.Channel;
@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("classpath:spring-beans.xml")
public class TestChannel {

	@Autowired
	ChannelService service;
	
	@Test
	public void testList(){
		List<Channel> list = service.list();
		list.forEach(x->{
			System.out.println("频道是"+ x);
			
		});
	}
	
}
