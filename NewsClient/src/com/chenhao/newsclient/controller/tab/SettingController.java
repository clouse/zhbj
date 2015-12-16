package com.chenhao.newsclient.controller.tab;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chenhao.newsclient.controller.TabController;

public class SettingController extends TabController {

	public SettingController(Context context) {
		super(context);
	}

	@Override
	public View initContentView(Context context) {
		TextView tv = new TextView(context);
		tv.setText("设置");
		tv.setTextSize(24);
		tv.setGravity(Gravity.CENTER);
		tv.setTextColor(Color.RED);
		return tv;
	}

}
