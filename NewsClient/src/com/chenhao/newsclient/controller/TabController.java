package com.chenhao.newsclient.controller;

import com.chenhao.newsclient.R;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class TabController {
	private Context mContext;
	private FrameLayout flContentContainer;
	protected ImageView ivMenu,ivListorGrid;
	protected TextView tvTitle;
	public TabController(Context context){
		mContext = context;
	}
	public View initView(){
		View mRootView = View.inflate(mContext, R.layout.item_base_tab, null);
		ivMenu = (ImageView) mRootView.findViewById(R.id.iv_base_tab_title_menu);
		ivListorGrid = (ImageView) mRootView.findViewById(R.id.iv_base_tab_listorgrid);
		tvTitle = (TextView) mRootView.findViewById(R.id.tv_base_tab_title);
		flContentContainer = (FrameLayout) mRootView.findViewById(R.id.fl_main_content_container);
		View contentView = initContentView(mContext);
		flContentContainer.addView(contentView);
		return mRootView;
	}
	public abstract View initContentView(Context context);
	public void initData(){
		
	}
}
