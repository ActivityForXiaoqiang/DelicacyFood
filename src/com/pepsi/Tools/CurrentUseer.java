package com.pepsi.Tools;

import com.alibaba.fastjson.JSON;

public class CurrentUseer {
	private String username;
	private String password;
	private int id;
	private static CurrentUseer user;

	public static CurrentUseer getCurrentUseer(UserInfo userinfo) {
		if (user == null) {
			user = new CurrentUseer(userinfo);
		}
		return user;

	}

	public static void Clear() {
		user = null;

	}

	private CurrentUseer(UserInfo userinfo) {

		username = userinfo.getUsername();
		password = userinfo.getPassword();
		id = userinfo.getId();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
