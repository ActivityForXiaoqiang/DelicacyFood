package com.pepsi.Activity;

import com.alibaba.fastjson.JSON;
import com.pepsi.Tools.Shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends BasedActivity {
	private Shop shop;
	private TextView shop_name, shop_labe, shop_location;
	private ImageView icon;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_detail);
		setback();
		setMine();
		setTitle("详情");
		dataInit();
		initView();
	}

	void initView() {
		icon = (ImageView) findViewById(R.id.shop_icon);
		icon.setBackgroundResource(shop.getIcon());
		shop_name = (TextView) findViewById(R.id.shop_name);
		shop_labe = (TextView) findViewById(R.id.shop_labe);
		shop_location = (TextView) findViewById(R.id.shop_location);
		shop_name.setText(shop.getName());
		shop_labe.setText(shop.getContent());
		shop_location.setText(shop.getLocation());
	}

	void dataInit() {
		Intent it = getIntent();
		shop = JSON.parseObject(it.getStringExtra("shop"), Shop.class);
	}
}
