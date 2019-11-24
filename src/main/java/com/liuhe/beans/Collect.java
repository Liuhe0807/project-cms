package com.liuhe.beans;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

//收藏
public class Collect {

	private int id       ;
	private int userId   ;
	@Length(min=2,max=128)
	@URL
	private String url      ;
	@Length(min=2,max=30)
	private String name     ;
	private Date created  ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Collect(int id, int userId, String url, String name, Date created) {
		super();
		this.id = id;
		this.userId = userId;
		this.url = url;
		this.name = name;
		this.created = created;
	}
	public Collect() {
		super();
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", userId=" + userId + ", url=" + url
				+ ", name=" + name + ", created=" + created + "]";
	}
	
	
}
