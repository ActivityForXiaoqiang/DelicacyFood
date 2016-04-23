package com.pepsi.Activity;

import com.pepsi.Tools.TOOL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SellerActivity extends BasedActivity {

	private RelativeLayout layout, seller_bg;
	private EditText login_username, login_password;
	private ImageView login;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.actvity_login);
		initView();
		SysApplication.getInstance().addActivity(this); 
	}

	void initView() {
		layout = (RelativeLayout) findViewById(R.id.Seller_relativeLayout);
		layout.setVisibility(View.GONE);
		seller_bg = (RelativeLayout) findViewById(R.id.seller_bg_layout);
		seller_bg.setBackgroundResource(R.drawable.seller_bg);

		login_username = (EditText) findViewById(R.id.login_username);
		login_password = (EditText) findViewById(R.id.login_password);
		login = (ImageView) findViewById(R.id.login_btn);
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!TOOL.Check(SellerActivity.this, login_username, login_password)) {
					return;
				}
				if (!TOOL.CheckSellerUser(SellerActivity.this, login_username, login_password)) {
					return;
				}

				startActivity(new Intent(SellerActivity.this, DingdanActivity.class));
				finish();
			}
		});

	}
}
