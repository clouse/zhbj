package com.chenhao.newsclient.activity;

import com.chenhao.newsclient.R;
import com.chenhao.newsclient.fragment.MainFragment;
import com.chenhao.newsclient.fragment.MenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

public class MainUI extends SlidingFragmentActivity {
	public static final String TAG_HOME_FRAGMENT = "HomeFragment";
	public static final String TAG_Menu_FRAGMENT = "MenuFragment";
	private FragmentManager fm;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		initView();
		initFragment();
	}

	private void initFragment() {
		fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.fl_main_container, new MainFragment(), TAG_HOME_FRAGMENT);
		ft.add(R.id.fl_menu_container, new MenuFragment(), TAG_Menu_FRAGMENT);
		ft.commit();
		
	}

	private void initView() {
		setContentView(R.layout.activity_main);
		setBehindContentView(R.layout.activity_menu);
		SlidingMenu slidingMenu = getSlidingMenu();
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setBehindOffset(400);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	}
}
