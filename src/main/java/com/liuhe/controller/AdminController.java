package com.liuhe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.liuhe.beans.User;
import com.liuhe.common.MsgResult;
import com.liuhe.service.UserService;
import com.liuhe.beans.Article;
import com.liuhe.service.ArticleService;
import com.liuhe.common.CmsAssert;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private UserService service;
	
	@Autowired
	private ArticleService  articleService;
	
	//首页
	@RequestMapping("index")
	public String index(){
		return "admin/index";
	}
	
	//status -1全部0待审核1审核通过2审核未通过
	@RequestMapping("articles")
	public String articles(HttpServletRequest request,
			@RequestParam(defaultValue="-1") int status,
			@RequestParam(defaultValue="1") Integer page) {
		PageInfo articlePage =  articleService.getPageList(status,page);
		request.setAttribute("pageInfo", articlePage);
		request.setAttribute("status", status);
		
		return "admin/article/list";
	}
	
	
	@RequestMapping("users")
	public String users(@RequestParam(defaultValue="")String name,@RequestParam(defaultValue="1")Integer pageNum,Model m){
		PageInfo info = service.list(name, pageNum);
		m.addAttribute("info", info);
		m.addAttribute("name", name);
	//	System.out.println("-------------------------------------------------------------");
		return "admin/user/list";
		
	}
	
	//用户接近或封禁用户
	@ResponseBody
	@RequestMapping("lockuser")
	public MsgResult lock(Integer userId,int status){
		if(status != 0 && status!=1) {
			return new MsgResult(2,"参数无效",null);
		}
		
		User user = service.getById(userId);
		
		if(user == null) {
			return new MsgResult(2,"该用户不存在",null);
		}

		if(user.getLocked()==status) {
			return new MsgResult(2,"无需做该操作",null);
		}
		
		int result = service.updateStatus(userId,status);
		if(result>0) {
			return new MsgResult(1,"恭喜您，处理成功",null);
		}else{
			return new MsgResult(2,"非常抱歉，处理失败，请与管理员联系！",null);
		}
		
		
	}
	
	@RequestMapping("getArticle")
	@ResponseBody
	public MsgResult getArticle(int id) {
		Article article = articleService.getDetailById(id);
		CmsAssert.AssertTrue(article!=null, "文章不存在");
		return new MsgResult(1,"获取成功",article);
	}
	
	@RequestMapping("applyArticle")
	@ResponseBody
	public MsgResult applyArticle(int id,int status) {
		Article article = articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文已经不存在");
		int result = articleService.apply( id,status);
		if(result>0) {
			return new MsgResult(1,"处理成功",null);
		}else {
			return new MsgResult(2,"处理失败",null);
		}
	}
	
	/**
	 * 设置热门与否
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping("setArticleHot")
	@ResponseBody
	public MsgResult setArticleHot(int id,int status) {
		Article article = articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文已经不存在");
		int result = articleService.setHot( id,status);
		if(result>0) {
			return new MsgResult(1,"处理成功",null);
		}else {
			return new MsgResult(2,"处理失败",null);
		}
	}
}
