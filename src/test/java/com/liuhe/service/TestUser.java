package com.liuhe.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.liuhe.beans.User;

public class TestUser extends TestBase{

	@Autowired
	UserService service;
	
	@Test
	public void testRegister(){
		User user = new User();
		user.setUsername("zhenshuaiwei");
		user.setPassword("123456");
		
		service.register(user);
	}
	
	@Test
	public void testLogin(){
		User user = new User();
		user.setUsername("zhenshuaiwei");
		user.setPassword("123456");
		User login = service.login(user);
		if(login==null){
			System.out.println("登录失败");
		}
		else{
			System.out.println("登录成功");
		}
		
	}
}
