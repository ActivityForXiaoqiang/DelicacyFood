package com.pepsi.Activity;

import com.pepsi.Tools.CurrentUseer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MySelfActvity extends BasedActivity {

	private TextView login_out;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_myself);
		setback();
		setMine();
		setTitle("个人中心");
		initView();
	}

	void initView() {
		login_out = (TextView) findViewById(R.id.mysef_login_out);
		login_out.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				CurrentUseer.Clear();
				Intent intent=new Intent(MySelfActvity.this, LoginActivity.class);
				intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();

			}
		});
	}
	
	
	@Override
	public void onBackPressed() {
		finish();
	}
}
