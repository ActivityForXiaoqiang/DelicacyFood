package com.pepsi.Activity;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.pepsi.Adapter.MySellerAdapter;
import com.pepsi.Myview.NoScrollListView;
import com.pepsi.Tools.CurrentUseer;
import com.pepsi.Tools.Order;
import com.pepsi.Tools.TOOL;

import android.os.Bundle;

public class DingdanActivity extends BasedActivity {
	private NoScrollListView listview;
	private ArrayList<Order> saveList;
	private ArrayList<Order> data;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_dingdan);
		setTitle("订单");
		setMine();
		initView();
	}

	void initView() {
		listview = (NoScrollListView) findViewById(R.id.list_dingdan_);
		saveList = (ArrayList<Order>) JSON.parseArray(TOOL.read(DingdanActivity.this, TOOL.ORDER), Order.class);
		data = new ArrayList<Order>();
		for (int i = 0; i < saveList.size(); i++) {
			Order r = saveList.get(i);
			if (CurrentUseer.getCurrentUseer(null).getUsername().equals(r.getSellerName())) {
				data.add(r);
			}
		}

		listview.setAdapter(new MySellerAdapter(this, data));

	}

}
