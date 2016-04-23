package com.pepsi.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class SellerActivity extends BasedActivity {

	private RelativeLayout layout, seller_bg;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.actvity_login);
		initView();
	}

	void initView() {
		layout = (RelativeLayout) findViewById(R.id.Seller_relativeLayout);
		layout.setVisibility(View.GONE);
		seller_bg = (RelativeLayout) findViewById(R.id.seller_bg_layout);
		seller_bg.setBackgroundResource(R.drawable.seller_bg);
	}
}
