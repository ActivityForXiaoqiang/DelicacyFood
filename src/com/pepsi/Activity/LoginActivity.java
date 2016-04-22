package com.pepsi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LoginActivity extends BasedActivity {

	private ImageView login_btn;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.actvity_login);
		initView();
	}

	void initView() {
		login_btn = (ImageView) findViewById(R.id.login_btn);
		login_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, MainActivity.class));
				finish();
			}
		});
	}
}
