package com.pepsi.Tools;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class TOOL {
	public static final String KEY = "MEISHI";
	public static final String UserKey = "userInfo";
	public static final String ORDER = "order";

	public static List<UserInfo> userList = new ArrayList<UserInfo>();

	/**
	 * 去掉标题栏
	 * 
	 * @param activity
	 */

	public static void NoTitleBar(Activity activity) {
		activity.requestWindowFeature(Window.FEATURE_NO_TITLE);

	}

	/**
	 * 去掉状态栏
	 * 
	 * @param activity
	 */
	public static void NoStateBar(Activity activity) {
		activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	/**
	 * 数据存储
	 * 
	 * @param con
	 * @param dataKey
	 * @param str
	 */
	public static void save(Context con, String dataKey, String str) {
		Log.i("xiaoqiang", str);
		SharedPreferences sp = con.getSharedPreferences(KEY, 0);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(dataKey, str);
		editor.commit();
	}

	/**
	 * 数据读取
	 * 
	 * @param con
	 * @param dataKey
	 * @return
	 */

	public static String read(Context con, String dataKey) {
		SharedPreferences sp = con.getSharedPreferences(KEY, 0);

		return sp.getString(dataKey, null);
	}

	/**
	 * 数据删除
	 * 
	 * @param con
	 */
	public static void delete(Context con) {
		SharedPreferences sp = con.getSharedPreferences(KEY, 0);
		SharedPreferences.Editor editor = sp.edit();
		editor.remove(KEY);
		editor.clear();
		editor.commit();
	}

	public static void UserInit(Context con) {

		UserInfo user = new UserInfo();
		user.setId(Attribute.BUYERS);
		user.setUsername("12345678901");
		user.setPassword("123456");
		userList.add(user);
		
		user = new UserInfo();
		user.setId(Attribute.SELLER);
		user.setUsername("12345678902");
		user.setPassword("123456");
		userList.add(user);
		save(con, UserKey, JSON.toJSONString(userList));

	}

	public static boolean Check(Context con, EditText ed, EditText pwd) {
		String str = ed.getText().toString();
		if (TextUtils.isEmpty(str)) {
			Toast.makeText(con, "手机号不能为空", 0).show();
			return false;
		}

		if (str.length() != 11) {
			Toast.makeText(con, "请输入正确手机号", 0).show();
			return false;
		}
		if (TextUtils.isEmpty(pwd.getText().toString())) {
			Toast.makeText(con, "密码不能为空", 0).show();
			return false;
		}
		return true;

	}

	/**
	 * 买家登录验证
	 * 
	 * @param con
	 * @param ed
	 * @param pwd
	 * @return
	 */

	public static boolean CheckUser(Context con, EditText ed, EditText pwd) {
		List<UserInfo> list = JSON.parseArray(read(con, UserKey), UserInfo.class);
		Log.i("xiaoqiang", list.size() + "----");
		for (int i = 0; i < list.size(); i++) {
			UserInfo u = list.get(i);
			if (u.getId() == Attribute.BUYERS) {
				if (!u.getUsername().equals(ed.getText().toString())) {
					Toast.makeText(con, "用户不存在", 0).show();
					return false;
				}
				if (!u.getPassword().equals(pwd.getText().toString())) {
					Toast.makeText(con, "密码", 0).show();
					return false;
				}
//				Log.i("xiaoqiang", TextUtils.isEmpty(u.getUsername())+"====");
				CurrentUseer user = CurrentUseer.getCurrentUseer(u);
			}
		}

		return true;

	}

	/**
	 * 卖家登录验证
	 * 
	 * @param con
	 * @param ed
	 * @param pwd
	 * @return
	 */
	public static boolean CheckSellerUser(Context con, EditText ed, EditText pwd) {
		List<UserInfo> list = JSON.parseArray(read(con, UserKey), UserInfo.class);
		for (int i = 0; i < list.size(); i++) {
			UserInfo u = list.get(i);
			if (u.getId() == Attribute.SELLER) {
				if (!u.getUsername().equals(ed.getText().toString())) {
					Toast.makeText(con, "用户不存在", 0).show();
					return false;
				}
				if (!u.getPassword().equals(pwd.getText().toString())) {
					Toast.makeText(con, "密码", 0).show();
					return false;
				}
				CurrentUseer user = CurrentUseer.getCurrentUseer(u);
			}
		}

		return true;

	}

}
