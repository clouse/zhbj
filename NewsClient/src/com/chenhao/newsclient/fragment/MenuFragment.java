package com.chenhao.newsclient.fragment;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;


public class MenuFragment extends BaseFragment {

	@Override
	protected View initView() {
		TextView tv = new TextView(mActivity);
		tv.setText("左侧菜单");
		tv.setTextSize(20);
		return tv;
	}

}
