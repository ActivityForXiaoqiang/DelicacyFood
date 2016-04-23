package com.pepsi.Activity;

import com.pepsi.Tools.TOOL;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class WelcomeActivity extends BasedActivity {
	private int[] welcome_items = { R.drawable.welcome_item1, R.drawable.welcome_item2, R.drawable.welcome_item3,
			R.drawable.welcome_item_end };

	private ViewPager viewpager;
	private int index = 0;
	private ImageView begin;
	private ImageView[] yuandian = new ImageView[4];
	private int[] ids = { R.id.welcome_item1, R.id.welcome_item2, R.id.welcome_item3, R.id.welcome_item4 };

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		// TOOL.NoStateBar(this);
		setContentView(R.layout.activity_welcome);
		initView();
	}

	void initView() {
		viewpager = (ViewPager) findViewById(R.id.welcome_viewpager);
		viewpager.setAdapter(new ViewPagerAdapter());
		viewpager.setOnPageChangeListener(viewpagerListener);
		viewpager.setCurrentItem(index);
		begin = (ImageView) findViewById(R.id.welcome_begin);
		begin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
				finish();
			}
		});
		for (int i = 0; i < ids.length; i++) {
			yuandian[i] = (ImageView) findViewById(ids[i]);
		}
		setPage(index);
		TOOL.UserInit(this);
	}

	OnPageChangeListener viewpagerListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int postion) {
			setPage(postion);
			if (postion != 3) {
				begin.setVisibility(View.GONE);
				return;
			}
			begin.setVisibility(View.VISIBLE);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	void setPage(int position) {
		for (int i = 0; i < ids.length; i++) {
			yuandian[i].setBackgroundResource(R.drawable.welcome_item_unselect);
		}
		yuandian[position].setBackgroundResource(R.drawable.welcome_item_select);
	}

	class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return welcome_items.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT);
			ImageView iv = new ImageView(WelcomeActivity.this);
			iv.setLayoutParams(mParams);
			iv.setImageResource(welcome_items[position]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			container.addView(iv);
			return iv;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			View view = (View) object;
			container.removeView(view);
		}

	}

}
