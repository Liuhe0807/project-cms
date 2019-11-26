package com.liuhe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.liuhe.beans.Article;

public interface ArticleMapper {

	//获取最新文章 @param i 获取个数
	List<Article>  newList(int i);
	//获取热门文章
	List<Article> hotList();
	
	//获取文章
	Article getById(Integer id);
	//根据频道获取文章
	List<Article> listByCat(@Param("chnId")int chnId, @Param("categoryId")int categoryId);
	//根据用户获取列表
	List<Article> listByUser(Integer userId);
	//删除
	@Update("UPDATE cms_article SET deleted=1 WHERE id=#{value}")
	int delete(int id);
	//检查是否存在
	@Select("SELECT id,title,user_id AS userId FROM cms_article WHERE id=#{value}")
	@ResultType(Article.class)
	Article checkExist(int id);
	
	//管理员根据状态查询文章
	/*@Select("select id,title,picture,channel_id,category_id,hits,commentCnt,created FROM cms_article WHERE deleted=0 AND status=1 AND hot=1")
	@ResultType(Article.class)*/
	List<Article> listByStatus(int status);

	// 获取文章详情，不考虑状态
	Article getDetailById(int id);

	// 审核文章 
	@Update(" UPDATE cms_article SET  status=#{status} "
			+ " WHERE id=#{id} ")
	int apply(@Param("id") int id,@Param("status") int status);


	// 设置热门
	@Update(" UPDATE cms_article SET  hot=#{status} "
			+ " WHERE id=#{id} ")
	int setHot(@Param("id") int id,@Param("status") int status);


	// 添加文章
	@Insert("INSERT INTO cms_article("
			+ " title,content,picture,channel_id,category_id,"
			+ " user_id,hits,hot,status,deleted,"
			+ " created,updated,commentCnt,articleType) "
			+ " values("
			+ " #{title},#{content},#{picture},#{channelId},#{categoryId},"
			+ "#{userId},#{hits},#{hot},#{status},#{deleted},"
			+ "now(),now(),#{commentCnt},#{articleType})")
	int add(Article article);

	// 修改文章
	@Update("UPDATE cms_article SET title=#{title},content=#{content},"
			+ "picture=#{picture},channel_id=#{channelId},"
			+ "category_id=#{categoryId},status=0,updated=now() WHERE id=#{id}")
	int update(Article article);
	
	@Insert(" replace cms_favorite(user_id,article_id,created) values(#{userId},#{articleId},now())")
	int favorite(@Param("userId")Integer userId, @Param("articleId")int articleId);
	
}
