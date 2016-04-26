package com.pepsi.Tools;

import java.util.ArrayList;
import java.util.List;

import com.pepsi.Activity.R;

public class Attribute {
	public static final int[] banner = { R.drawable.banner_dangao, R.drawable.banner_quqi, R.drawable.banner_makalong };
	public static final int[] content_hot = { R.drawable.banner_quqi, R.drawable.content_kafei,
			R.drawable.banner_makalong, R.drawable.content_shuiguo };
	public static final int[] content_tuijian = { R.drawable.banner_dangao, R.drawable.content_pangxie,
			R.drawable.banner_makalong, R.drawable.content_caiguan };

	public static final int[] icons = { R.drawable.banner_dangao, R.drawable.banner_quqi, R.drawable.banner_makalong,
			R.drawable.content_kafei, R.drawable.content_shuiguo, R.drawable.content_caiguan,
			R.drawable.content_pangxie }; 
	public static final String[][] location = { { "30.1354550000", "120.1593410000", "西湖区狮闻线" },
			{ "30.1954060000", "120.2237310000", "滨江区江陵路609号309室" },
			{ "30.2453370000", "120.1800380000", "上城区河坊街61-2" }, { "30.2113870000", "120.2168320000", "滨江区江南大道" },
			{ "30.2076420000", "120.2293370000", "滨江区阡陌路" }, { "30.2226220000", "120.1862180000", "上城区钱江路130号" },
			{ "30.2402200000", "120.2431350000", "萧山区坤宁路" } };

	public static String[] shop_name = { "克莉丝汀", "香港奇华", "嘟菲西点", "星巴克", " 果园春色", "小南国", "岳阳楼" };
	public static String[] shop_contetn = { "蛋糕店", "甜点店", "coffer店 甜点店", "coffer店", "水果店", "高级餐厅", "高级餐厅" };

	public static List<Shop> store;
	public static String[] SellUsernmae = { "12345678902", "12345678903", "12345678904", "12345678905", "12345678906",
			"12345678907", "12345678908" };
	
	public static String[] tabs = { "甜食", "甜食", "甜食", "咖啡", "水果",
		"土菜", "海鲜" };

	

	public static List<Shop> InitStore() {
		store = new ArrayList<Shop>();
		for (int i = 0; i < icons.length; i++) {
			Shop p = new Shop();
			p.setLat(location[i][0]);
			p.setLon(location[i][1]);
			p.setLocation(location[i][2]);
			p.setIcon(icons[i]);
			p.setName(shop_name[i]);
			p.setContent(shop_contetn[i]);
			p.setSellerUser(SellUsernmae[i]);
			p.setTab(tabs[i]);
			store.add(p);

		}
		return store;
	}

	public static final int BUYERS = 1;
	public static final int SELLER = 2;

}
