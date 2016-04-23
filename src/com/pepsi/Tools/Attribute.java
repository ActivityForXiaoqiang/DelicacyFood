package com.pepsi.Tools;

import java.util.List;

import com.pepsi.Activity.R;

public class Attribute {
	public static final int[] banner = { R.drawable.banner_dangao, R.drawable.banner_quqi, R.drawable.banner_makalong };
	public static final int[] content_hot = { R.drawable.banner_quqi, R.drawable.content_kafei,
			R.drawable.banner_makalong, R.drawable.content_shuiguo };
	public static final int[] content_tuijian = { R.drawable.banner_dangao, R.drawable.content_pangxie,
			R.drawable.banner_makalong, R.drawable.content_caiguan };

	public static final int[] icons = { R.drawable.banner_dangao, R.drawable.banner_quqi, R.drawable.banner_makalong,
			R.drawable.content_kafei, R.drawable.content_shuiguo, R.drawable.content_caiguan,
			R.drawable.content_pangxie };
	public static List<Shop> store;

	public static void InitStore() {
		for (int i = 0; i < icons.length; i++) {
			
		}
	}
}
