package com.liuhe.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.liuhe.beans.User;
import com.liuhe.common.Md5;

public class TestUser extends TestBase{

	@Autowired
	UserService service;
	
	@Test
	public void testRegister(){
		User user = new User();
		user.setUsername("zxc");
		user.setPassword("123456");
		
		service.register(user);
		
		/*User xiaojian = new User();
		xiaojian.setUsername("xiaojian");
		xiaojian.setPassword("123456");
		
		service.register(xiaojian);*/
	}
	
	@Test
	public void testLogin(){
		User user = new User();
		user.setUsername("lh");
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
