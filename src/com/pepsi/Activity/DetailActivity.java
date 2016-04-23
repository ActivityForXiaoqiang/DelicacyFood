package com.pepsi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.pepsi.Tools.Shop;

public class DetailActivity extends BasedActivity {
	private Shop shop;
	private TextView shop_name, shop_labe, shop_location;
	private ImageView icon;
	
	private RelativeLayout to_baidu_dingwei;

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
		to_baidu_dingwei=(RelativeLayout) findViewById(R.id.to_baidu_dingwei);
		shop_labe = (TextView) findViewById(R.id.shop_labe);
		shop_location = (TextView) findViewById(R.id.shop_location);
		shop_name.setText(shop.getName());
		shop_labe.setText(shop.getContent());
		shop_location.setText(shop.getLocation());
		
		to_baidu_dingwei.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(DetailActivity.this, BaiduMapActivity.class);
				it.putExtra("shop", JSON.toJSONString(shop));
				startActivity(it);
			}
		});
	}

	void dataInit() {
		Intent it = getIntent();
		shop = JSON.parseObject(it.getStringExtra("shop"), Shop.class);
		
		
		
		
	}
	
}
