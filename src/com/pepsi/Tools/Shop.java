package com.pepsi.Tools;

import java.util.Map;

public class Shop {
	private String lat;
	private String lon;
	private String name;
	private String content;
	private int icon;
	private Map<String, String> goods;
	private String location;
	

	public Map<String, String> getGoods() {
		return goods;
	}

	public void setGoods(Map<String, String> goods) {
		this.goods = goods;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

}
