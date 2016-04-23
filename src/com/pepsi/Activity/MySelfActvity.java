package com.pepsi.Activity;

import android.os.Bundle;

public class MySelfActvity extends BasedActivity {
	
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_myself);
		setback();
		setMine();
		setTitle("个人中心");

	}

	void initView() {
		
	}
}
