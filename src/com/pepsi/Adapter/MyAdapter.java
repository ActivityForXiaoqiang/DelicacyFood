package com.pepsi.Adapter;

import java.util.ArrayList;

import com.pepsi.Activity.R;
import com.pepsi.Tools.Shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {

	Context context;
	ArrayList<Shop> data;

	public MyAdapter(Context context, ArrayList<Shop> data) {
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder h;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.list_item, null);
			h = new viewHolder();
			h.img = (ImageView) convertView.findViewById(R.id.item_img);
			convertView.setTag(h);
		} else {
			h = (viewHolder) convertView.getTag();
		}
		if (data != null && data.size() > 0) {
			Shop p = data.get(position);
			h.img.setBackgroundResource(p.getIcon());
		}
		return convertView;
	}

	class viewHolder {
		ImageView img;
	}

}
