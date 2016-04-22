package com.pepsi.Activity;

import java.util.ArrayList;
import java.util.List;

import com.pepsi.Adapter.MyAdapter;
import com.pepsi.Myview.NoScrollListView;
import com.pepsi.Tools.Attribute;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends BasedActivity {
	private ViewPager viewpager;
	private NoScrollListView tuijian, hot;
	int index = 0;
	ArrayList<Integer> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	void initView() {
		viewpager = (ViewPager) findViewById(R.id.main_viewpager);
		viewpager.setAdapter(new ViewPagerAdapter());
		viewpager.setOnPageChangeListener(viewpagerListener);
		viewpager.setCurrentItem(index);
		viewpager.setFocusable(true);
		viewpager.setFocusableInTouchMode(true);
		viewpager.requestFocus();
		handler.sendEmptyMessageDelayed(1, 5 * 1000);
		tuijian = (NoScrollListView) findViewById(R.id.main_list_tuijian);
		data = new ArrayList<Integer>();
		for (int i = 0; i < Attribute.content_tuijian.length; i++) {
			data.add(Attribute.content_tuijian[i]);
		}
		tuijian.setAdapter(new MyAdapter(this, data));
		tuijian.setOnItemClickListener(tuijianListener);
		hot = (NoScrollListView) findViewById(R.id.main_list_hot);
		data = new ArrayList<Integer>();
		for (int i = 0; i < Attribute.content_hot.length; i++) {
			data.add(Attribute.content_hot[i]);
		}
		hot.setAdapter(new MyAdapter(this, data));
		hot.setOnItemClickListener(hotListener);
	}

	OnItemClickListener tuijianListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent it = new Intent(MainActivity.this, DetailActivity.class);
			it.putExtra("index", position);
			startActivity(it);
		}
	};
	OnItemClickListener hotListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent it = new Intent(MainActivity.this, DetailActivity.class);
			it.putExtra("index", position);
			startActivity(it);
		}
	};
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			if (index == 2) {
				index = 0;
			} else {
				index++;
			}
			viewpager.setCurrentItem(index);
			handler.sendEmptyMessageDelayed(1, 3 * 1000);

		}
	};

	OnPageChangeListener viewpagerListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			index = arg0;
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
	};

	class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Attribute.banner.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT);
			ImageView iv = new ImageView(MainActivity.this);
			iv.setLayoutParams(mParams);
			iv.setImageResource(Attribute.banner[position]);
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
