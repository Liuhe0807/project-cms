package com.liuhe.beans;
//分类
public class Category {

	private Integer id;
	private String name;
	private int channelId;
	private Channel channel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Category(Integer id, String name, int channelId, Channel channel) {
		super();
		this.id = id;
		this.name = name;
		this.channelId = channelId;
		this.channel = channel;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "CateGory [id=" + id + ", name=" + name + ", channelId="
				+ channelId + ", channel=" + channel + "]";
	}
	
	
}
