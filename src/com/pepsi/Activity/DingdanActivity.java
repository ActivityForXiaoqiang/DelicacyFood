package com.pepsi.Activity;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.pepsi.Adapter.MySellerAdapter;
import com.pepsi.Myview.NoScrollListView;
import com.pepsi.Tools.CurrentUseer;
import com.pepsi.Tools.Order;
import com.pepsi.Tools.TOOL;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class DingdanActivity extends BasedActivity {
	private NoScrollListView listview;
	private ArrayList<Order> saveList;
	private ArrayList<Order> data;
	private TextView ADD;

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
		data = new ArrayList<Order>();
		saveList = (ArrayList<Order>) JSON.parseArray(TOOL.read(DingdanActivity.this, TOOL.ORDER), Order.class);
		if (saveList != null) {
			for (int i = 0; i < saveList.size(); i++) {
				Order r = saveList.get(i);
				if (CurrentUseer.getCurrentUseer(null).getUsername().equals(r.getSellerName())) {
					data.add(r);
				}
			}
		}

		listview.setAdapter(new MySellerAdapter(this, data));
		ADD = (TextView) findViewById(R.id.dingdan_add);
		ADD.setVisibility(View.VISIBLE);
		ADD.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog dialog = new AlertDialog.Builder(DingdanActivity.this).create();
				dialog.show();
				Window window = dialog.getWindow();
				window.setContentView(R.layout.dialog_view);
			}
		});
	}

}
