package com.pepsi.Activity;

import com.alibaba.fastjson.JSON;
import com.pepsi.Tools.Attribute;
import com.pepsi.Tools.TOOL;
import com.pepsi.Tools.UserInfo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistActivity extends BasedActivity {
	private EditText username, paddword;
	private TextView regist;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.actvity_regist);
		initView();
	}

	void initView() {
		username = (EditText) findViewById(R.id.regist_username);
		paddword = (EditText) findViewById(R.id.regist_password);
		regist = (TextView) findViewById(R.id.login_regist);
		regist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!TOOL.Check(RegistActivity.this, username, paddword)) {
					return;
				}
				UserInfo u = new UserInfo();
				u.setId(Attribute.BUYERS);
				u.setUsername(username.getText().toString());
				u.setPassword(paddword.getText().toString());
				TOOL.userList=JSON.parseArray(TOOL.read(RegistActivity.this, TOOL.UserKey), UserInfo.class);
				TOOL.userList.add(u);
				TOOL.save(RegistActivity.this, TOOL.UserKey, JSON.toJSONString(TOOL.userList));
				Toast.makeText(RegistActivity.this, "注册成功", 0).show();
				finish();
			}
		});
	}
}
