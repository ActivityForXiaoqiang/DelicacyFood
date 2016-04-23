package com.pepsi.Activity;

import com.pepsi.Tools.CurrentUseer;
import com.pepsi.Tools.ScreenManager;
import com.pepsi.Tools.TOOL;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends BasedActivity {

	private ImageView login_btn;
	private TextView zhuce, shangjia;
	private EditText login_username, login_password;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.actvity_login);
		initView();
	}

	void initView() {
		login_username = (EditText) findViewById(R.id.login_username);
		login_password = (EditText) findViewById(R.id.login_password);

		login_btn = (ImageView) findViewById(R.id.login_btn);
		login_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!TOOL.Check(LoginActivity.this, login_username, login_password)) {
					return;
				}
				if (!TOOL.CheckUser(LoginActivity.this, login_username, login_password)) {
					return;
				}

				// Log.i("xiaoqiang",
				// CurrentUseer.getCurrentUseer(null).getUsername());

				startActivity(new Intent(LoginActivity.this, MainActivity.class));
				finish();
			}
		});

		zhuce = (TextView) findViewById(R.id.zhuce);
		zhuce.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(LoginActivity.this, "暂未开放", 0).show();
			}
		});
		shangjia = (TextView) findViewById(R.id.shangjia);
		shangjia.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				startActivity(new Intent(LoginActivity.this, SellerActivity.class));
			}
		});
	}

	@Override
	public void onBackPressed() {
		finish();
	}
}
