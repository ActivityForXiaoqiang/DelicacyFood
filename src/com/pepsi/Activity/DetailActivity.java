package com.pepsi.Activity;

import java.util.ArrayList;
import java.util.Date;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.pepsi.Tools.Order;
import com.pepsi.Tools.Shop;
import com.pepsi.Tools.TOOL;

public class DetailActivity extends BasedActivity {
	private Shop shop;
	private TextView shop_name, shop_labe, shop_location;
	private ImageView icon;

	private RelativeLayout to_baidu_dingwei;

	private Button btn_yuyue;
	private Button btn_dingcan;

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
		btn_yuyue = (Button) findViewById(R.id.btn_yuyue);
		btn_dingcan = (Button) findViewById(R.id.btn_dingcan);

		shop_name = (TextView) findViewById(R.id.shop_name);
		to_baidu_dingwei = (RelativeLayout) findViewById(R.id.to_baidu_dingwei);
		shop_labe = (TextView) findViewById(R.id.shop_labe);
		shop_location = (TextView) findViewById(R.id.shop_location);
		shop_name.setText(shop.getName());
		shop_labe.setText(shop.getContent());
		shop_location.setText(shop.getLocation());

		to_baidu_dingwei.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(DetailActivity.this,
						BaiduMapActivity.class);
				it.putExtra("shop", JSON.toJSONString(shop));
				startActivity(it);
			}
		});

		btn_dingcan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		final ArrayList<Order> orderList = new ArrayList<Order>();

		Order order = new Order();
		order.setPicId(shop.getIcon());
		order.setTime("" + new Date().toString());
		order.setStory(shop.getName());
		// order.setUser(TOOL.read(this, TOOL.UserKey));
		orderList.add(order);

		if (null != TOOL.read(this, TOOL.ORDER)) {
			ArrayList<Order> saveList = (ArrayList<Order>) JSON.parseArray(
					TOOL.read(this, TOOL.ORDER), Order.class);
			for (int i = 0; i < saveList.size(); i++) {
				Order or = saveList.get(i);
				orderList.add(or);
			}

		}

		btn_yuyue.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				TOOL.save(DetailActivity.this, TOOL.ORDER,
						JSON.toJSONString(orderList));
				Toast.makeText(DetailActivity.this, "预约成功", 0).show();
			}
		});

	}

	void dataInit() {
		Intent it = getIntent();
		shop = JSON.parseObject(it.getStringExtra("shop"), Shop.class);

	}

}
