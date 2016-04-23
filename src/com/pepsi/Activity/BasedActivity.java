package com.pepsi.Activity;

import com.pepsi.Tools.TOOL;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BasedActivity extends FragmentActivity {
	private LinearLayout back, mine;
	TextView title;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		TOOL.NoTitleBar(this);

	}

	public void setback() {
		back = (LinearLayout) findViewById(R.id.back);
		back.setVisibility(View.VISIBLE);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	public void setMine() {
		mine = (LinearLayout) findViewById(R.id.mine);
		mine.setVisibility(View.GONE);
	}

	public void setTitle(String str) {
		title = (TextView) findViewById(R.id.top_title);
		title.setText(str);
	}

}
