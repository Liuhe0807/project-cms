package com.liuhe.beans;

public class Favorite {

	private Integer id;
	private Integer user_id;
	private Integer article_id;
	private Integer created;
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getCreated() {
		return created;
	}
	public void setCreated(Integer created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Favorite [id=" + id + ", user_id=" + user_id + ", article_id="
				+ article_id + ", created=" + created + "]";
	}
	
	
}
