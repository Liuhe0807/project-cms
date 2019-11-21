package com.liuhe.beans;

import java.sql.Date;



public class Article {

	private Integer id;
	private String title;
	private String content;
	private String picture;
	//频道
	private Integer channelId;
	private Channel channel;
	private String catgoryId;
	//文章的分类
	private Category category;
	
	private Integer userId;
	private User user;
	
	//点击数量
	private int hits;
	//是否为热门文章 1是 0否
	private int hot;
	//0待审核 1审核通过2审核未通过
	private int status;
	//是否被删除
	private int deleted;
	//发表时间
	private Date created;
	//最后修改时间
	private Date updated;
	//评论的数量
	private int commentCnt;
	//文章类型
	private int articleType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public String getCatgoryId() {
		return catgoryId;
	}
	public void setCatgoryId(String catgoryId) {
		this.catgoryId = catgoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public int getArticleType() {
		return articleType;
	}
	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}
	public Article(Integer id, String title, String content, String picture,
			Integer channelId, Channel channel, String catgoryId,
			Category category, Integer userId, User user, int hits, int hot,
			int status, int deleted, Date created, Date updated,
			int commentCnt, int articleType) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.channelId = channelId;
		this.channel = channel;
		this.catgoryId = catgoryId;
		this.category = category;
		this.userId = userId;
		this.user = user;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.commentCnt = commentCnt;
		this.articleType = articleType;
	}
	public Article() {
		super();
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content="
				+ content + ", picture=" + picture + ", channelId=" + channelId
				+ ", channel=" + channel + ", catgoryId=" + catgoryId
				+ ", category=" + category + ", userId=" + userId + ", user="
				+ user + ", hits=" + hits + ", hot=" + hot + ", status="
				+ status + ", deleted=" + deleted + ", created=" + created
				+ ", updated=" + updated + ", commentCnt=" + commentCnt
				+ ", articleType=" + articleType + "]";
	}
	
	
	
}
