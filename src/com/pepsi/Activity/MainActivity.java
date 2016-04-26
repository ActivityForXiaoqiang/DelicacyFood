package com.pepsi.Activity;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pepsi.Adapter.MyAdapter;
import com.pepsi.Myview.NoScrollListView;
import com.pepsi.Tools.Attribute;
import com.pepsi.Tools.Shop;
import com.pepsi.Tools.TOOL;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends BasedActivity {
	private ViewPager viewpager;
	private NoScrollListView tuijian, hot;
	int index = 0;
	List<Shop> data;
	private LinearLayout mine;

	private Button btn_serarch;
	
	private MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		SysApplication.getInstance().addActivity(this);
	}

	void initView() {

		btn_serarch = (Button) findViewById(R.id.btn_search);

		mine = (LinearLayout) findViewById(R.id.mine);
		
		btn_serarch.setVisibility(View.VISIBLE);

		btn_serarch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final View contens_view = LayoutInflater
						.from(MainActivity.this).inflate(
								R.layout.contents_view, null);
				final EditText editText = (EditText) contens_view
						.findViewById(R.id.edit_text);
				AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
						.setTitle("搜索")
						.setNegativeButton("确定",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										List<Shop> dataSerarch = new ArrayList<Shop>();

										for (int i = 0; i < data.size(); i++) {
											Shop shop = data.get(i);
											String serarch = editText.getText()
													.toString();
											// 模糊匹配
											if (serarch.contains(shop.getTab())
													|| serarch.contains(shop
															.getName())) {
												dataSerarch.add(shop);
											}

										}
										if (dataSerarch.size() == 0) {
											Toast.makeText(MainActivity.this,
													"没有该商品", 0).show();
										} else {
											
											adapter.clear();
											adapter.addAll(dataSerarch);
											Toast.makeText(MainActivity.this,
													"搜索到"+dataSerarch.size()+"条数据", 0).show();
										}
									}
								})

						.setView(contens_view).create();
				builder.show();

			}
		});

		mine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, MySelfActvity.class));
			}
		});
		viewpager = (ViewPager) findViewById(R.id.main_viewpager);
		viewpager.setAdapter(new ViewPagerAdapter());
		viewpager.setOnPageChangeListener(viewpagerListener);
		viewpager.setCurrentItem(index);
		viewpager.setFocusable(true);
		viewpager.setFocusableInTouchMode(true);
		viewpager.requestFocus();
		handler.sendEmptyMessageDelayed(1, 5 * 1000);
		tuijian = (NoScrollListView) findViewById(R.id.main_list_tuijian);
		data = Attribute.InitStore();
		// for (int i = 0; i < Attribute.content_tuijian.length; i++) {
		// data.add(Attribute.content_tuijian[i]);
		// }
		adapter=new MyAdapter(this, (ArrayList<Shop>) data);
		tuijian.setAdapter(adapter);
		tuijian.setOnItemClickListener(tuijianListener);
		hot = (NoScrollListView) findViewById(R.id.main_list_hot);
		// data = new ArrayList<Integer>();
		// for (int i = 0; i < Attribute.content_hot.length; i++) {
		// data.add(Attribute.content_hot[i]);
		// }
		
		hot.setAdapter(new MyAdapter(this, (ArrayList<Shop>) data));
		hot.setOnItemClickListener(hotListener);
	}

	OnItemClickListener tuijianListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent it = new Intent(MainActivity.this, DetailActivity.class);
			it.putExtra("shop", JSON.toJSONString(data.get(position)));
			startActivity(it);
		}
	};
	OnItemClickListener hotListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent it = new Intent(MainActivity.this, DetailActivity.class);
			it.putExtra("shop", JSON.toJSONString(data.get(position)));
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
			LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
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
