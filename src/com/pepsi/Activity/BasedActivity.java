package com.pepsi.Activity;

import com.pepsi.Tools.TOOL;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BasedActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		TOOL.NoTitleBar(this);

	}
	
	
	
	
}
