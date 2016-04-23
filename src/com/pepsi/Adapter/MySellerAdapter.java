package com.pepsi.Adapter;

import java.util.ArrayList;

import com.pepsi.Activity.R;
import com.pepsi.Tools.Order;
import com.pepsi.Tools.Shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySellerAdapter extends BaseAdapter {

	Context context;
	ArrayList<Order> data;

	public MySellerAdapter(Context context, ArrayList<Order> data) {
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
			convertView = View.inflate(context, R.layout.list_item_seller, null);
			h = new viewHolder();
			h.img = (ImageView) convertView.findViewById(R.id.seller_list_icon);
			h.name=(TextView) convertView.findViewById(R.id.seller_list_user);
			h.store=(TextView) convertView.findViewById(R.id.seller_list_name);
			h.time=(TextView) convertView.findViewById(R.id.seller_list_time);
			convertView.setTag(h);
		} else {
			h = (viewHolder) convertView.getTag();
		}
		if (data != null && data.size() > 0) {
			Order r=data.get(position);
			h.img.setBackgroundResource(r.getPicId());
			h.name.setText(r.getUser());
			h.store.setText(r.getStory());
			h.time.setText(r.getTime());
			
			
		}
		return convertView;
	}

	class viewHolder {
		ImageView img;
		TextView name,store,time;
	}

}
