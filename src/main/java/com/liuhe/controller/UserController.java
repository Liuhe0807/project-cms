package com.liuhe.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.liuhe.beans.Article;
import com.liuhe.beans.Channel;
import com.liuhe.beans.User;
import com.liuhe.common.CmsAssert;
import com.liuhe.common.ConstantClass;
import com.liuhe.service.ArticleService;
import com.liuhe.service.ChannelService;
import com.liuhe.service.UserService;
import com.liuhe.common.MsgResult;







@Controller
@RequestMapping("user")
public class UserController {
	
	Logger log = Logger.getLogger(UserController.class);
	
	
	@Value("${upload.path}")
	String updloadPath;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ArticleService articleService;
	
	
	@Autowired
	ChannelService channelService;

	private SimpleDateFormat dateFormat;
	
	@Autowired
	private UserService service;
	//  httppxxxx://user/hello
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String tet(HttpServletRequest request) {
		request.setAttribute("info", "hello");
		return "user/test";
	}
	
	
	
	//跳转注册页面
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(Model m){
		
		return "user/register";
		
	}

	//处理用户提交的注册的数据
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(Model m,User user){
		//用户名是否存在
		User existUser = service.findByName(user.getUsername());
		CmsAssert.AssertTrue(existUser==null, "该用户已经存在");
		
		int result = service.register(user);
		CmsAssert.AssertTrue(result>0, "用户注册失败，请稍后再试");
		
		return "redirect:/user/login";
		
	}
	
	//跳转登录页面
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		
		return "/user/login";
		
	}
	
	//处理用户提交的登录的数据
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,User user){
		
		System.out.println("=========================================");
		User loginUser  = userService.login(user);
		// 用户存在 登录成功
		if(loginUser!=null) {
			request.getSession().setAttribute(ConstantClass.USER_KEY, loginUser);
			
			//return "redirect:/";
			return loginUser.getRole()==ConstantClass.USER_ROLE_ADMIN
					?"redirect:/admin/index":"redirect:/user/home";
		}else {
			request.setAttribute("errorMsg", "用户名或密码错误！！");
			request.setAttribute("user", user);
			return "user/login";
		}
		
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute(ConstantClass.USER_KEY);
		return "redirect:/";
		
	}
	
	//检查
	@RequestMapping("checkname")
	@ResponseBody
	public boolean checkname(String username){
		return null==service.findByName(username);
	}
	//个人中心
	@RequestMapping("home")
	public String home(HttpServletRequest request) {
		return "/user/home";
	}
	
	/**
	 * 获取文章列表
	 * @return
	 */
	@RequestMapping("myarticles")
	public String myarticles(HttpServletRequest request,
			@RequestParam(defaultValue="1") int page) {
		
		User loginUser = (User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		PageInfo<Article> pageInfo=  articleService.listByUser(page,loginUser.getId());
		request.setAttribute("pageInfo", pageInfo);
		return "user/myarticles";
	}
	@RequestMapping("delArticle")
	@ResponseBody
	public MsgResult delArticle(HttpServletRequest request,int id){
		
		CmsAssert.AssertTrue(id>0, "文章id必须大于0");
		Article article =  articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文章不存在");
		
		User loginUser = (User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		CmsAssert.AssertTrue(
				loginUser.getRole()==ConstantClass.USER_ROLE_ADMIN 
				|| loginUser.getId()==article.getUserId(),
				"只有管理员和文章的作者能删除文章");
		
		int result = articleService.delete(id);
		CmsAssert.AssertTrue(result>0,"文章删除失败");
		return new MsgResult(1,"删除成功",null);
		
	}
	//进入发表文章的界面
	@GetMapping("postArticle")
	public String postArticle(HttpServletRequest request) {
		
		// 获取所有的频道
		List<Channel> channels =  channelService.list();
		request.setAttribute("channels", channels);
		return "article/publish";
	}
	
	/**
	 * 上传文件的规则
	 *  文件扩展名不能改变
	 *  保存到某个路径下边  要求子目录
	 *  子目录  每天一个子目录
	 */
	@PostMapping("postArticle")
	@ResponseBody
	public MsgResult postArticle(HttpServletRequest request, MultipartFile file,Article article) throws IllegalStateException, IOException{
		
		if(!file.isEmpty()) {
			String fileUrl = processFile(file);
			article.setPicture(fileUrl);
		}
		User loginUser  = (User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		article.setUserId(loginUser.getId());
		
		int result = articleService.add(article);
		if(result>0) {
			return new MsgResult(1, "处理成功",null);
		}else {
			return new MsgResult(2, "添加失败，请稍后再试试！",null);
		}
	}


	
	private String processFile(MultipartFile file) throws IllegalStateException, IOException {
		
		log.info("updloadPath is "  + updloadPath);
    	
    	//1 求扩展名  "xxx.jpg"
    	String suffixName =  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
    	String fileNamePre = UUID.randomUUID().toString();
    	// 计算出新的文件名称
    	String fileName = fileNamePre + suffixName;
    	
    	dateFormat = new SimpleDateFormat("yyyyMMdd");
    	String path = dateFormat.format(new Date());
    	File pathFile  = new File(updloadPath + "/" + path);
    	if(!pathFile.exists()) {
    		pathFile.mkdirs();
    	}
    	
    	// 最终的新的文件名称
    	String newFileName = updloadPath + "/"+ path + "/" + fileName;
    	file.transferTo(new File(newFileName));
    	
    	return path + "/" + fileName ;
	}
	
	//回显
	@GetMapping("updateArticle")
	public String updateArticle(HttpServletRequest request,int id) {
		
		// 获取文章的详情 用于回显
		Article article = articleService.getDetailById(id);
		request.setAttribute("article", article);
		request.setAttribute("content1", htmlspecialchars(article.getContent()));
		
		System.out.println(" 将要修改文章 " + article);
		 
		// 获取所有的频道
		List<Channel> channels =  channelService.list();
		request.setAttribute("channels", channels);
		
		return "article/update";
	}
	//修改文章
	@PostMapping("updateArticle")
	@ResponseBody
	public MsgResult updateArticle(HttpServletRequest request,
			MultipartFile file, Article article) throws IllegalStateException, IOException {
		//文章id 是否存在
		
		//用户是否有权限修改
		
		//
		if(!file.isEmpty()) {
			String picUrl = processFile(file);
			article.setPicture(picUrl);
		}
		
		int result = articleService.update(article);
		
		if(result>0) {
			// 成功
			return new MsgResult(1,"",null);
		}else {
			return new MsgResult(2,"失败",null);
		}
		
	}
	
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}

	
}
