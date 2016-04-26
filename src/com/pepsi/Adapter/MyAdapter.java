package com.pepsi.Adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pepsi.Activity.R;
import com.pepsi.Tools.Shop;

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
	
	public void addAll(List<Shop> elem) {
        data.addAll(elem);
        notifyDataSetChanged();
    }
	 /** Clear data list */
    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder h;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.list_item, null);
			h = new viewHolder();
			h.tab=(TextView) convertView.findViewById(R.id.item_tab);
			h.img = (ImageView) convertView.findViewById(R.id.item_img);
			convertView.setTag(h);
		} else {
			h = (viewHolder) convertView.getTag();
		}
		if (data != null && data.size() > 0) {
			Shop p = data.get(position);
			h.img.setBackgroundResource(p.getIcon());
			h.tab.setText(p.getTab());
		}
		return convertView;
	}

	class viewHolder {
		ImageView img;
		TextView tab;
	}

}
