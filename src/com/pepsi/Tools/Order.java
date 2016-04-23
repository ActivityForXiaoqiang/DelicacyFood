package com.pepsi.Tools;


public class Order {
	
	/**
	 * 时间
	 */
	private String time;
	
	/**
	 * 用户
	 */
	private String user;
	
	/**
	 * 图片Id
	 */
	private int picId;
	
	/**
	 * 店名
	 */
	private String story;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}
}
