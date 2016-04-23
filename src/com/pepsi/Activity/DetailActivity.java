package com.pepsi.Activity;

import android.os.Bundle;

public class DetailActivity extends BasedActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_detail);
		setback();
		setMine();
		setTitle("详情");
	}
	
}
