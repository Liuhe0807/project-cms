package com.liuhe.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.liuhe.beans.Article;

public class TestArticle extends TestBase{

	@Autowired
	ArticleService service;
	
	@Test
	public void testHotList(){
		PageInfo<Article> hotlist = service.hotlist(1);
		List<Article> list = hotlist.getList();
		list.forEach(a->{
			System.out.println("a is"+a);
		});
	}
	
}
