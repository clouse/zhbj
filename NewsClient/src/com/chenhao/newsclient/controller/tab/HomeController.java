package com.chenhao.newsclient.controller.tab;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chenhao.newsclient.controller.TabController;

public class HomeController extends TabController {

	public HomeController(Context context) {
		super(context);
	}

	@Override
	public View initContentView(Context context) {
		TextView tv = new TextView(context);
		tv.setText("首页");
		tv.setTextSize(24);
		tv.setGravity(Gravity.CENTER);
		tv.setTextColor(Color.RED);
		return tv;
	}

}
