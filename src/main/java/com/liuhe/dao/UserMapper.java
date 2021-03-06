package com.liuhe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.liuhe.beans.User;

public interface UserMapper {

	List<User> list(String name);
	
	User getById(Integer userId);
	@Update("UPDATE cms_user SET locked=${status} WHERE id=${userId}")
	int updateStatus(@Param("userId")Integer userId,@Param("status")int status);
	@Select("SELECT * FROM cms_user WHERE username = #{value} limit 1")
	User findByUserName(String username);
	//添加注册
	int add(User user);
	
	//@Select("select * from cms_favorite where user_id=#{value}")
	List getFavoriteList(Integer id);
}
