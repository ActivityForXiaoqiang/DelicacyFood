package com.pepsi.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pepsi.Tools.CurrentUseer;
import com.pepsi.Tools.TOOL;

public class MySelfActvity extends BasedActivity {

	private TextView login_out;
	
	private TextView person_taste;
	
	private RelativeLayout infoLayout;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_myself);
		setback();
		setMine();
		setTitle("个人中心");
		initView();
		SysApplication.getInstance().addActivity(this); 
	}

	void initView() {
		login_out = (TextView) findViewById(R.id.mysef_login_out);
		
		person_taste=(TextView) findViewById(R.id.person_taste);
		
		infoLayout=(RelativeLayout) findViewById(R.id.myself_info);
		
		String taste=TOOL.read(MySelfActvity.this, TOOL.TASTE);
		if (null !=taste && !"".equals(taste)) {
			person_taste.setText("个人口味: " +taste);
		}
		
		infoLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				final View contens_view = LayoutInflater.from(MySelfActvity.this)
						.inflate(R.layout.contents_view, null);
				final EditText editText = (EditText) contens_view
						.findViewById(R.id.edit_text);
				AlertDialog builder = new AlertDialog.Builder(MySelfActvity.this)
						.setTitle("输入口味")
						.setNegativeButton("确定", new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								TOOL.save(MySelfActvity.this, TOOL.TASTE, editText.getText().toString());
								
								Toast.makeText(MySelfActvity.this, "添加成功", 0).show();
							}
						})

						.setView(contens_view).create();
				builder.show();
				
			}
		});
		
		
		login_out.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				CurrentUseer.Clear();
				SysApplication.getInstance().exit();

			}
		});
	}
	
	
	
	
}
