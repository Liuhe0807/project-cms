package com.liuhe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.liuhe.beans.Link;

public interface LinkMapper {

	//展示
	@Select("select * from cms_link order by created desc")
	List getLinkList(Integer pageNum);
	//添加
	@Insert("inset into cms_link set url=#{url},name=#{name},created=now()")
	void add(Link link);
	
}
