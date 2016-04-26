package com.pepsi.Activity;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.pepsi.Adapter.CommentAdapter;
import com.pepsi.Myview.NoScrollListView;
import com.pepsi.Tools.CurrentUseer;
import com.pepsi.Tools.TOOL;
import com.pepsi.Tools.comment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;

public class PinglunActivity extends BasedActivity {
	private TextView submit;
	private NoScrollListView list;
	private ArrayList<comment> data;
	private ArrayList<comment> Alldata;
	private EditText ed;
	private CommentAdapter adapter;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_pinglun);
		setMine();
		setback();
		setTitle("评论");
		initView();

	}

	void initView() {
		datainit();
		list = (NoScrollListView) findViewById(R.id.comments_listview);
		adapter = new CommentAdapter(this, data);
		list.setAdapter(adapter);
		ed = (EditText) findViewById(R.id.pinglun_edtext);
		submit = (TextView) findViewById(R.id.pinglun);
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (TextUtils.isEmpty(ed.getText().toString())) {
					return;
				}

				comment c = new comment();
				c.setContent(ed.getText().toString());
				c.setUsername(CurrentUseer.getCurrentUseer(null).getUsername());
				c.setSeller(getIntent().getStringExtra("seller"));
				data.add(c);
				adapter.notifyDataSetChanged();
				TOOL.save(PinglunActivity.this, TOOL.COMMENTS, JSON.toJSONString(data));

			}
		});

	}

	void datainit() {
		data = new ArrayList<comment>();
		String str = TOOL.read(this, TOOL.COMMENTS);
		if (TextUtils.isEmpty(str)) {
			Alldata = new ArrayList<comment>();
			return;
		}
		Alldata = (ArrayList<comment>) JSON.parseArray(str, comment.class);
		for (int i = 0; i < Alldata.size(); i++) {
			comment c = Alldata.get(i);
			if (c.getSeller().equals(getIntent().getStringExtra("seller"))) {
				data.add(c);
			}
		}

	}

}
