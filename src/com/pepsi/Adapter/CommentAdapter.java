package com.pepsi.Adapter;

import java.util.ArrayList;

import com.pepsi.Activity.R;
import com.pepsi.Tools.Shop;
import com.pepsi.Tools.comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CommentAdapter extends BaseAdapter {

	Context context;
	ArrayList<comment> data;

	public CommentAdapter(Context context, ArrayList<comment> data) {
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
			convertView = View.inflate(context, R.layout.comment_list_item, null);
			h = new viewHolder();
			h.username = (TextView) convertView.findViewById(R.id.comment_username);
			h.content = (TextView) convertView.findViewById(R.id.commet_content);
			convertView.setTag(h);
		} else {
			h = (viewHolder) convertView.getTag();
		}
		if (data != null && data.size() > 0) {
			comment c = data.get(position);
			h.username.setText(c.getUsername());
			h.content.setText(c.getContent());
		}
		return convertView;
	}

	class viewHolder {
		TextView username, content;
	}

}
