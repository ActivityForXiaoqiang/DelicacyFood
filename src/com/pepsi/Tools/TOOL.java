package com.pepsi.Tools;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class TOOL {
	
	/**
	 * 去掉标题栏
	 * @param activity
	 */
	
	public static void NoTitleBar(Activity activity) {
		activity.requestWindowFeature(Window.FEATURE_NO_TITLE);

	}
/**
 * 去掉状态栏
 * @param activity
 */
	public static void NoStateBar(Activity activity) {
		activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}
}
